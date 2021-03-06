package org.springframework.samples.the_ionian_bookshelf.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="items")
public class Item extends BaseEntity {

	@Column(unique = true, name = "title")
	@NotBlank
	@Size(max = 40)
	private String title;

	@NotBlank
	@Size(min = 10, max = 500)
	@Column(name = "description")
	private String description;

	@ElementCollection
	@CollectionTable(name="item_attributes", joinColumns=@JoinColumn(name="item_id"))
	@NotEmpty
	@Size(min = 3, max = 3)
	@Column(name="attributes")
	private List<String> attributes;

//	@ElementCollection
	@NotEmpty
	@Valid
	@Size(min = 1, max = 3)
	@ManyToMany
	@JoinTable(name="item_roles", joinColumns = @JoinColumn(name="item_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> roles;

	@Override
	public String toString() {
		return title;
	}
	

}