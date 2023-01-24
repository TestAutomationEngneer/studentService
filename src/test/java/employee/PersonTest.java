package employee;

import com.example.Student;
import com.example.repository.PersonRepository;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
public class PersonTest {

    @Inject
    PersonRepository personRepository;
    @Test
    public void shouldSaveEmployeeObjectToDB() {
//        Student darek = new Student(null, "Darek");
//        Student savedEmployee = personRepository.save(darek);
//        assertThat(savedEmployee).isNotNull();
    }
}
