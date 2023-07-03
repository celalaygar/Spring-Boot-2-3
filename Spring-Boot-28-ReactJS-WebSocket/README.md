# Spring-Boot-28-ReactJS-WebSocket


### front end
to run frontend first install `sockjs-client, stompjs, web-vitals` 
```
npm i sockjs-client
npm i stompjs
npm i web-vitals
npm start
```
After starting if you see this problem ` Module not found: Error: Can't resolve 'net' in 'node_modules/stompjs/lib'` you need to type this code on terminal
```
npm i net -S
```
for this problem Reference link: 
https://stackoverflow.com/questions/54275069/module-not-found-error-cant-resolve-net-in-node-modules-stompjs-lib
