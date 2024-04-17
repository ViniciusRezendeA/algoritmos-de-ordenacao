import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public List<Acomodacao> sort(List<Acomodacao> acomodacoes) {
        if (acomodacoes.size() == 1) {
            return acomodacoes;
        }
        List<Acomodacao> part1 = new ArrayList<Acomodacao>();
        List<Acomodacao> part2 = new ArrayList<Acomodacao>();
        List<Acomodacao> result = new ArrayList<Acomodacao>();
        for (int i = 0; i < (acomodacoes.size() / 2); i++) {
            part1.add(acomodacoes.get(i));
        }

        for (int i = (acomodacoes.size() / 2); i < acomodacoes.size(); i++) {
            part2.add(acomodacoes.get(i));

        }

        part1 = this.sort(part1);
        part2 = this.sort(part2);

        for (int i = 0; i < acomodacoes.size(); i++) {
            if (part1.size() >= 1 && part2.size() >= 1) {
                if (part1.getFirst().getHostId() < part2.getFirst().getHostId()) {
                    result.add(part1.removeFirst());
                } else if (part1.getFirst().getHostId() > part2.getFirst().getHostId()) {
                    result.add(part2.removeFirst());
                } else if (part1.getFirst().getRoomId() > part2.getFirst().getRoomId()) {
                    result.add(part2.removeFirst());
                } else {
                    result.add(part1.removeFirst());
                }
            }
        }
        
        return result;
    }
}
