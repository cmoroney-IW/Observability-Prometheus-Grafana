#!/bin/sh
curl -i -X GET \
        --url http://kong:8001/
status=$?
echo  ${status}
while [ ${status} -ne 0 ]
do
    sleep 1
    echo ${status}
    curl -i -X GET --url http://kong:8001/
    status=$?
done  


curl -i -X POST \
--url http://kong:8001/services/ \
--data name=GetAllCustomers \
--data 'url=http://postgres-spring:8000/all'
curl -i -X POST \
--url http://kong:8001/services/GetAllCustomers/routes/ \
    -H "Content-Type: application/json" \
    -d '{"name": "allCustomers", "methods":["GET"], "hosts":["localhost"], "paths":["/"]}'


curl -i -X POST \
--url http://kong:8001/services/ \
--data name=CreateCustomer \
--data 'url=http://postgres-spring:8000/create'
curl -i -X POST \
--url http://kong:8001/services/CreateCustomer/routes/ \
    -H "Content-Type: application/json" \
    -d '{"name": "create", "methods":["POST"], "hosts":["localhost"], "paths":["/"],"headers":{"Content-Type":["application/json"]}}'


curl -i -X POST \
--url http://kong:8001/services/ \
--data name=DeleteCustomer \
--data 'url=http://postgres-spring:8000/delete'
curl -i -X POST \
--url http://kong:8001/services/DeleteCustomer/routes/ \
    -H "Content-Type: application/json" \
    -d '{"name": "delete", "methods":["DELETE"], "hosts":["localhost"], "paths":["/"]}'


curl -i -X POST \
--url http://kong:8001/services/ \
--data name=GetCustomer \
--data 'url=http://postgres-spring:8000/'
curl -i -X POST \
--url http://kong:8001/services/GetCustomer/routes/ \
    -H "Content-Type: application/json" \
    -d '{"name": "customer", "methods":["GET"], "hosts":["localhost"], "paths":["/"]}'