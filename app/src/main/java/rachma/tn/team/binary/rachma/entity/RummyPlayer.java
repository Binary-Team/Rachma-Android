package rachma.tn.team.binary.rachma.entity;

/**
 * Created by marwen on 07/08/17.
 */

public class RummyPlayer {

    String name;
    Integer score;


    public RummyPlayer(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RummyPlayer)) return false;

        RummyPlayer that = (RummyPlayer) o;

        if (!getName().equals(that.getName())) return false;
        return getScore().equals(that.getScore());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getScore().hashCode();
        return result;
    }
}
