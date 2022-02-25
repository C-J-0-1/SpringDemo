/*SELECT 
    *
FROM
    sql_store.orders AS o
WHERE
    YEAR(o.order_date) = 2017;*/

/*SELECT 
    *
FROM
    sql_store.order_items AS o
WHERE
    o.order_id = 6 AND o.quantity * o.unit_price > 30;*/
    
/*SELECT 
    *
FROM
    sql_inventory.products AS p
WHERE
    p.quantity_in_stock IN (49 , 38, 72);*/
    
/*SELECT 
    *
FROM
    sql_store.customers AS c
WHERE
    c.birth_date BETWEEN '1990-01-01' AND '2000-01-01';*/
    
/*SELECT 
    *
FROM
    sql_store.customers AS c
WHERE
    c.address LIKE '%trail%'
        OR c.address LIKE '%avenue%'
        OR c.phone LIKE '%9';*/

/*SELECT 
    *
FROM
    sql_store.customers AS c
WHERE
    c.first_name REGEXP '^[ae]'
        OR c.last_name REGEXP 'ey$|on$'
        OR c.last_name REGEXP '^my|se'
        OR c.last_name REGEXP 'b[ru]';*/
        
/*SELECT 
    *
FROM
    sql_store.orders AS o
WHERE
    o.shipped_date IS NULL
        AND o.shipper_id IS NULL;*/
        
/*SELECT 
    *
FROM
    sql_store.order_items AS o
WHERE
    o.order_id = 2
ORDER BY o.quantity * o.unit_price DESC;*/

/*SELECT 
    *
FROM
    sql_store.customers AS c
ORDER BY c.points DESC
LIMIT 3;*/

/*SELECT 
    o.*, p.name
FROM
    sql_store.order_items AS o
        JOIN
    sql_store.products AS p ON o.product_id = p.product_id;*/
    
/*SELECT 
    c.client_id, p.payment_id, p.date, p.amount, pa.name
FROM
    sql_invoicing.payments AS p
        JOIN
    sql_invoicing.clients AS c ON c.client_id = p.client_id
        JOIN
    sql_invoicing.payment_methods AS pa ON pa.payment_method_id = p.payment_id;*/
    
/*SELECT 
    p.product_id, p.name, o.quantity
FROM
    sql_store.products AS p
        LEFT JOIN
    sql_store.order_items AS o ON p.product_id = o.product_id;*/
    
/*SELECT 
    o.order_date, o.order_id, c.first_name, sh.name, os.name
FROM
    sql_store.orders AS o
        LEFT JOIN
    sql_store.shippers AS sh ON o.shipper_id = sh.shipper_id
        LEFT JOIN
    sql_store.customers AS c ON o.customer_id = c.customer_id
        LEFT JOIN
    sql_store.order_statuses AS os ON o.status = os.order_status_id
ORDER BY os.name;*/

/*SELECT 
    p.date, c.name, p.amount, pm.name
FROM
    sql_invoicing.payments AS p
        JOIN
    sql_invoicing.clients AS c USING (client_id)
        JOIN
    sql_invoicing.payment_methods AS pm ON p.payment_method = pm.payment_method_id;*/

/*SELECT 
    c.customer_id, c.first_name, c.points, 'Bronze' AS Type
FROM
    sql_store.customers AS c
WHERE
    c.points < 2000 
UNION SELECT 
    c.customer_id, c.first_name, c.points, 'Silver'
FROM
    sql_store.customers AS c
WHERE
    c.points BETWEEN 2000 AND 3000 
UNION SELECT 
    c.customer_id, c.first_name, c.points, 'Gold'
FROM
    sql_store.customers AS c
WHERE
    c.points > 3000 
ORDER BY first_name;*/

/*CREATE TABLE invoiced_archived AS SELECT i.invoice_id,
    i.number,
    c.name,
    i.invoice_total,
    i.payment_total,
    i.invoice_date,
    i.due_date,
    i.payment_date FROM
    invoices AS i
        JOIN
    clients AS c ON c.client_id = i.client_id
WHERE
    i.payment_date IS NOT NULL;*/
    
/*UPDATE sql_store.orders AS o 
SET 
    o.comments = 'Gold Customers'
WHERE
    o.customer_id IN (SELECT 
            c.customer_id
        FROM
            sql_store.customers AS c
        WHERE
            c.points > 3000);*/
            