package com.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "BLACK_OFFER_DATA")
@NoArgsConstructor
@AllArgsConstructor
public class BlackOffer {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer end_year;
	private Integer intensity;
	private String topic;
	private String region;
	private String city;
	private String country;
	private String relevance;
	private Integer likelihood;
}
