package one.digitalinovation.personapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinovation.personapi.entities.Person;
import one.digitalinovation.personapi.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Person findById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person.get();
	}
	
	public Person create(Person person) {
		return personRepository.save(person);
	}
	
	public void delete(Long id) {
		personRepository.deleteById(id);
	}
	
	public Person update(Long id, Person obj) {
		Person person = personRepository.getOne(id);
		updateData(person, obj);
		return personRepository.save(person);
	}

	private void updateData(Person person, Person obj) {
		person.setFirstName(obj.getFirstName());
		person.setLastName(obj.getLastName());
	}
}
