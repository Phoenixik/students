package services;

import models.studentlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.StudentlistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class myservice {

    @Autowired
    StudentlistRepository studentrepo;

    studentlist slist = new studentlist();

    public void saveall(String name, String country, String mobile) {
        slist.setName(name);
        slist.setMobile(mobile);
        slist.setCountry(country);

        if(slist.getCountry().equalsIgnoreCase("jamaica")) {
            System.out.println("mail sent to " + slist.getName());
        }

        studentrepo.save(slist);
        System.out.println("done");
    }
    public List<studentlist> retrieveall() {
         return studentrepo.findAll();
    }

    public Optional<studentlist> retrieve(String id) {
        System.out.println(studentrepo.findById(Integer.parseInt(id)));
        return(studentrepo.findById(Integer.parseInt(id)));
    }

    public studentlist update(String name, String country, String mobile, String id){

        System.out.println(id);
        slist.setName(name);
        slist.setMobile(mobile);
        slist.setCountry(country);
        slist.setId(Integer.parseInt(id));

        return studentrepo.save(slist);
    }
    public void delete(String id){

        System.out.println(id);
         studentrepo.deleteById(Integer.parseInt(id));
    }

}
