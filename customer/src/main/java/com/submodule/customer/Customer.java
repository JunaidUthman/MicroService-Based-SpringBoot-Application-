package com.submodule.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
// --- REMOVE THIS IMPORT ---
// import org.springframework.data.annotation.Id;
// --- Use the JPA imports below ---
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    // The @Id annotation from javax.persistence is now used correctly
    @Id
    @SequenceGenerator(name="customer_id_sequence",sequenceName="customer_id_sequence")// name is a logical name used to reference this configuration within the JPA code , sequenceName is the physical name of the sequence in the actual PostgreSQL database.
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="customer_id_sequence") // GenerationType.SEQUENCE is the best way to generate IDs in postgress, refers to th ename in SequenceGenerator
    private Integer id;

    private String firstname;
    private String lastname;
    private String email;

}