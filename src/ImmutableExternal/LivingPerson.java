package ImmutableExternal;

import Immutable_Class.Person;
import Immutable_Class.PersonImmutable;

import java.util.Arrays;

public class LivingPerson  extends PersonImmutable {

    protected LivingPerson(String name, PersonImmutable[] kids) {
        super(name, null, kids == null ? new PersonImmutable[10] :
                Arrays.copyOf(kids, 10));
    }

    protected LivingPerson(PersonImmutable person) {
        super(person);
    }

    @Override
    public String getDob() {
        return null;
    }

    public void addKid(PersonImmutable person){
        for(int i = 0 ; i < kids.length ; i++){
            if(kids[i] == null){
                kids[i] = person;
                break;
            }
        }

    }
}
