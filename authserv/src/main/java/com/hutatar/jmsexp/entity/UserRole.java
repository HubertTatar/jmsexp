package com.hutatar.jmsexp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "auth")
public class UserRole {

    @EmbeddedId
    private Id id = new Id();

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", insertable=false, updatable=false)
    protected Role role;

    public Role getRole() {
        return role;
    }

    @Embeddable
    public static class Id implements Serializable {
        private static final long serialVersionUID = 1322120000551624359L;

        @Column(name = "APP_USER_ID")
        protected Long userId;

        @Enumerated(EnumType.STRING)
        @Column(name = "ROLE")
        protected Role role;

        public Id() { }

        public Id(Long userId, Role role) {
            this.userId = userId;
            this.role = role;
        }
    }
}
