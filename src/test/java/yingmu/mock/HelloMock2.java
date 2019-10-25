package yingmu.mock;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author zhouxiang
 * @date 2019/10/25-14:39
 */
public class HelloMock2 {
    @Test
    public void capturing_args() {
        PersonDao personDao = mock(PersonDao.class);
        PersonService personService = new PersonService(personDao);

        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);
        personService.update(1, "jack");
        // 参数捕获器验证捕获的参数是否符合传入方法的参数要求，
        // personDao.update(Person),argument.capture()返回不是person类型则验证失败。
        verify(personDao).update(argument.capture());
        assertEquals(1, argument.getValue().getId());
        assertEquals("jack", argument.getValue().getName());
    }
    class Person {
        private int id;
        private String name;
        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
    }
    interface PersonDao {
        public void update(Person person);
    }
    class PersonService {
        private PersonDao personDao;
        PersonService(PersonDao personDao) {
            this.personDao = personDao;
        }
        public void update(int id, String name) {
            personDao.update(new Person(id, name));
        }
    }
}
