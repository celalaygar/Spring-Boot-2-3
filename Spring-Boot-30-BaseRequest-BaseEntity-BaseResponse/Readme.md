save category curl for postman

```
curl --location 'localhost:5555/api/categories' \
--header 'Content-Type: application/json' \
--data '{
    "body":{
        "categoryName":"Kadın Kıyafeti",
        "parentCategoryId": null
    }
}'

```
