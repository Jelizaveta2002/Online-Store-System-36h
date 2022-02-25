package ee.taltech.iti0202.tk1.art;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

    public class Collector {
        public static HashMap<Collector, ArrayList<Painting>> map = new HashMap<>();

        public Collector() {
            map.put(this, new ArrayList<>());
        }

        public boolean addPainting(Painting painting) {
            System.out.println(map);
            if (! map.get(this).isEmpty() && painting != null) {
                for (Painting pic : map.get(this)) {
                    if (pic.getAuthor().equals(painting.getAuthor())) {
                        return false;
                    }
                }
                map.get(this).add(painting);
                return true;
            }
            map.get(this).add(painting);
            return true;
        }

        public boolean ifTheSameBuyer(Collector seller, Collector buyer) {
            return buyer.getPaintings().equals(seller.getPaintings());
        }

        public boolean sellPainting(Painting painting, Collector fellowCollector) {
            if (ifTheSameBuyer(this, fellowCollector) && fellowCollector.addPainting(painting)) {
                return true;
            }
            return false;
        }

        public List<Painting> getPaintings() {
            return map.get(this);
        }
    }
