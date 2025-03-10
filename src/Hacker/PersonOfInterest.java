package Hacker;


import Immutable_Class.PersonImmutable;

public class PersonOfInterest extends PersonImmutable {
    public PersonOfInterest(PersonImmutable person) {
        super(person);
    }

    @Override
    public PersonImmutable[] getKids() {
        return super.kids;
    }

}
