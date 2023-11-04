//package Pracownia.Projekt.Spring.Services;
//
//import Pracownia.Projekt.Spring.Entities.Library;
//import Pracownia.Projekt.Spring.Repositories.LibraryRepository;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Optional;
//@Rollback(false)
//@DataJpaTest
//class LibraryServiceTest {
//
//    @Autowired
//    private LibraryRepository libraryRepository;
//
//    // test - nowa biblioteka
//    @Test
//    public void testAddNew() {
//        Library l = new Library("Katowice", "Biblioteka Katowicka");
//        Library savedLibrary = libraryRepository.save(l);
//
//        Assertions.assertThat(savedLibrary).isNotNull();
//        Assertions.assertThat(savedLibrary.getLibrary_id()).isGreaterThan(0);
//    }
//
//    @Test
//    public void testListAll() {
//        Library l2 = new Library("Katowice", "Biblioteka Katowicka");
//        Library savedLibrary = libraryRepository.save(l2);
//        Iterable<Library> l = libraryRepository.findAll();
//        Assertions.assertThat(l).hasSizeGreaterThan(0);
//
//        for (Library library : l) {
//            System.out.println(library);
//        }
//    }
//
//    @Test
//    public void testUpdate() {
//        Library l3 = new Library("Katowice", "Biblioteka Katowicka");
//        libraryRepository.save(l3);
//        Integer libraryId = l3.getLibrary_id();
//        Library l1 = libraryRepository.findById(libraryId).get();
//
//        l1.setCity("Szczecin");
//        libraryRepository.save(l1);
//
//        Library updateLibrary = libraryRepository.findById(libraryId).get();
//        Assertions.assertThat(updateLibrary.getCity()).isEqualTo("Szczecin");
//
//    }
//    @Test
//    public void testDelete(){
//        Library l3 = new Library("Katowice", "Biblioteka Katowicka");
//        Library l4 = new Library("Szczecin", "Biblioteka S.");
//        Library savedLibrary3 = libraryRepository.save(l3);
//        Library savedLibrary4 = libraryRepository.save(l4);
//        Assertions.assertThat(savedLibrary3).isNotNull();
//        Assertions.assertThat(savedLibrary4).isNotNull();
//
//        Integer libraryId = l4.getLibrary_id();
//        libraryRepository.deleteById(libraryId);
//
//        Assertions.assertThat(libraryRepository.findById(libraryId)).isNotPresent();
//    }
//}