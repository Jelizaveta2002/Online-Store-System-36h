package ee.taltech.iti0202.tk1.art;

import java.util.ArrayList;
import java.util.List;

    public class Collector {
        private ArrayList<Painting> list = new ArrayList<>();

        public boolean addPainting(Painting painting) {
            if (! list.isEmpty() && painting != null) {
                for (Painting pic : list) {
                    if (pic.getAuthor().equals(painting.getAuthor()) && pic.getTitle().equals(painting.getTitle())) {
                        return false;
                    }
                }
                list.add(painting);
                return true;
            }
            return false;
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
            return list;
        }
    }
