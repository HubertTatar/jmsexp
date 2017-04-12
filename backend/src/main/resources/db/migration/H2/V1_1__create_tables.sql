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
        order_id decimal(19,0)
    );

 create table orders.bugs (
       id decimal(19,0) not null,
        created_date timestamp,
        modification_date timestamp,
        version integer,
        created_by varchar(255),
        description varchar(255),
        severity smallint,
        status smallint,
        title varchar(255),
        updated_by varchar(255)
    );