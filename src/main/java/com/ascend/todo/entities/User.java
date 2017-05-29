package com.ascend.todo.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;


/**
 * Created by BiG on 5/27/2017 AD.
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue
    Long id;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createDate;

    @LastModifiedDate
    @Temporal(TIMESTAMP)
    private Date updatedDate;

    private String firstName;

    private String lastName;

    private String email;
}
