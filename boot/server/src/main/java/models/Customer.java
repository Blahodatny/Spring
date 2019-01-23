package models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Customer")
@Table(name = "customers", catalog = "Boot", schema = "public")
public class Customer {
}