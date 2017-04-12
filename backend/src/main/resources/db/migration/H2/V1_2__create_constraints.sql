ALTER TABLE orders.orders ADD PRIMARY KEY(id);

ALTER TABLE orders.order_comments ADD PRIMARY KEY(id);

alter table orders.order_comments
       add constraint order_comments_fk1
       foreign key (order_id)
       references orders.orders;


alter table orders.bugs
       add constraint bugs_idx_1 unique (id, version);

alter table orders.order_comments
       add constraint order_comments_idx_1 unique (id, version);

alter table orders.orders
       add constraint orders_idx_1 unique (id, version);