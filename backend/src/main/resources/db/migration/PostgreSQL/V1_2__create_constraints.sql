ALTER TABLE orders.orders ADD  PRIMARY KEY(id);

ALTER TABLE orders.order_comments ADD  PRIMARY KEY(id);

    alter table orders.order_comments
       add constraint order_comments_fk1
       foreign key (order_id)
       references orders.orders;