    create table orders.order_comments (
       id numeric(19, 0) not null,
        created_date timestamp,
        modification_date timestamp,
        version int4,
        text varchar(255),
        order_id numeric(19, 0)
    );

    create table orders.orders (
       id numeric(19, 0) not null,
        created_date timestamp,
        modification_date timestamp,
        version int4,
        product_name varchar(255),
        quantity int4 not null,
        status int4
    );