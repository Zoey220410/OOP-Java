java.lang.String;
public class Group {
    private final String[] people;

    public Group(String[] people) {
        if(people != null) {
            this.people = new String[people.length];
            for(int i=0; i<people.length; i++) {
                this.people[i] = people[i];
            }
        }else {
            this.people = new String[0];
        }
    }

    public int size() {
        return people.length;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(String person: people) {
            res.append(person).append('/');
        }
        return res.toString().isEmpty() ? "" : res.substring(0, res.length() - 1);
    }
}
