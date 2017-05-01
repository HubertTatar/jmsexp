alter table auth.user_role
  add CONSTRAINT user_role_pk
  PRIMARY KEY (role, app_user_id);

alter table auth.sec_app_user
        add constraint sec_app_user_idx_2 unique (username);

alter table auth.user_role
        add constraint user_role_fk1
        foreign key (sec_app_user_id)
        references auth.sec_app_user;

