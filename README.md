# Spring-Boot-Practice
This repo will try to explore the functionalies of spring boot, spring security, spring data jpa.

----------------------
Annotations
-------------
-@SpringBootApplication
-@Controller
-@RequestBody
-@ResponseBody
-@RestController
-@RequestMapping
-@GetMapping
-@PostMapping
-@PutMapping
-@DeleteMapping
-@Service
-@ControllerAdvice
-@Value

jpa
---
-@Entity
-@Table
-@Column
-@Id
-@JsonIgnore
-@JsonProperty
-Validation--@NOTBLANK,NOTNULL,NOTEMPTY,,,@Email--hibernate validator
-@CreationTimestamp
-@UpdateTimestamp

lombok
-------
-@setter
-@getter
-@toString
-@Data
-@NoArgsConstructor
-@AllArgsConstructor

-To add dependencies can be done from start.spring.io or project starter.

- Use ResponseEntity to wrap up response with http status.\
200 - OK.
201 - CREATED.
204 - NO CONTENT.

-Jpa provides methods to communicate to the database through repository(crud,jpa,pagingandsorting)
**save,findall,findById,findByName,deleteById
**Save can either create or update base on whether the primary key is provided and exists.
**jpa provides jpql querys to complement the repositories.

@Controller + @ResponseBody = @RestController.

@Value is used to read values from application.properties file eg @Value("${server.port}"),,default values can be provided.

Http methods
--------------
GET
DELETE
POST
PUT

Project structure
-----------------
--main application with @SpringBootApplication.
--controller - exposes the rest api through @RestController,@***Mapping
--repository interface- extends jpa,crud or paging and sorting repositories to provide access to the database layer.
--service - interface and implementation class,,, the interface implements repository,,, implementation implements the interface
--model - represent the db entities.







