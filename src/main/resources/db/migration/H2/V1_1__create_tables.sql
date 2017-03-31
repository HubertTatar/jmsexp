create table orders.orders (
        id decimal(19,0) not null,
        created_date timestamp,
        modification_date timestamp,
        version integer,
        product_name varchar(255),
        quantity integer not null,
        status integer
    );

create table orders.order_comments (
       id decimal(19,0) not null,
        created_date timestamp,
        modification_date timestamp,
        version integer,
        text varchar(255),
        order_id decimal(19,0),
    );