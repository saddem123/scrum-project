package tn.esprit.rh.achat.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private int id;

	private String email;
	private String pwd;
	private String firstName;
	private String lastName;
	@Enumerated(EnumType.STRING)
	private Role role;


	@ManyToMany
	private Set<Project> projets;

	@OneToMany
	private Set<Project> masterProjets;


}
