# Spring-Boot-27-PostgreSQL-Trigger-Java-Listener

I have three trigger and I tried all of them on java. this project can be used how to listen trigger to catch changing on related table.


### imnsert trigger
``` 
CREATE OR REPLACE FUNCTION notify_table_inserted1() RETURNS TRIGGER AS $$
BEGIN
    PERFORM pg_notify(CAST('key' AS text), row_to_json(NEW)::text);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION notify_table_inserted2() RETURNS TRIGGER AS $$
BEGIN
    PERFORM pg_notify(
        CAST('insert' AS text),
        CAST( '{"action":"'|| TG_OP || '","table":"' || TG_TABLE_NAME || '","new-value": ' AS text) 
        || row_to_json(NEW)::text || '}'
        );
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER notify_table_inserted
    AFTER INSERT ON customer_table FOR EACH ROW
    EXECUTE PROCEDURE notify_table_inserted2();
``` 

### update trigger 
``` 
CREATE OR REPLACE FUNCTION notify_table_updated1() RETURNS TRIGGER AS $$
BEGIN
    PERFORM pg_notify(
            CAST('update' AS text),
            CAST( '{"action":"'|| TG_OP || '","table":"'|| TG_TABLE_NAME || '","old-value": ' AS text) 
            || row_to_json(OLD)::text
            || CAST(',"new-value": ' AS text) || row_to_json(NEW)::text || '}'
        );
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER notify_table_updated
    AFTER UPDATE ON customer_table FOR EACH ROW
EXECUTE PROCEDURE notify_table_updated1();
``` 




### delete trigger is ok
``` 
CREATE OR REPLACE FUNCTION notify_table_deleted1() RETURNS TRIGGER AS $$
BEGIN
    PERFORM pg_notify(
            CAST('delete' AS text),
            CAST('{"action":"'|| TG_OP || '","table":"' || TG_TABLE_NAME || '"' AS text)
            ||
            CAST(',"old-value": ' AS text) || row_to_json(OLD)::text || '}'
        );
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER notify_table_deleted
    AFTER DELETE ON customer_table FOR EACH ROW
EXECUTE PROCEDURE notify_table_deleted1();
``` 

