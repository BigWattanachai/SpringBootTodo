package com.ascend.todo.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;


/**
 * Created by BiG on 5/27/2017 AD.
 */
@Entity
@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class User {
    @Id
    @GeneratedValue
    Long id;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createDate;

    @LastModifiedBy
    @Temporal(TIMESTAMP)
    private Date updatedDate;

    private String firstName;
    private String lastName;
    private String email;
}
