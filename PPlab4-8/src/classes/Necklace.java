package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Necklace implements ICost, Serializable {
    List<Stone> stones;

    public Necklace(Stone stone) {
        this.stones = new ArrayList<Stone>();
    }
    public Necklace(List<Stone> stone) {
        this.stones = stone;
    }
    public Necklace() {
        this.stones = new ArrayList<Stone>();
    }
    public void AddStone(Stone stone){
        stones.add(stone);
    }
    public double Cost(){
        double cost = 0;
        for(int i = 0; i < stones.size(); i++){
            cost += stones.get(i).price;
        }
        return cost;
    }
    public double Weight(){
        double weight = 0;
        for(int i = 0; i < stones.size(); i++){
            weight += stones.get(i).carats;
        }

        return weight;
    }
    public void SortByPrice(){
        stones.sort((d1, d2) -> {
            return (int)(d2.price - d1.price);
        });
    }
    public void SetNecklace(Necklace n){
        this.stones = n.stones;
    }
//    public List<Stone> GetStones(){
//        return stones;
//    }
//    public void SetStones(List<Stone> s){
//        stones = s;
//    }
    @Override
    public String toString() {
        String lace = "Necklace: \n";
        for(int i = 0; i < stones.size(); i++){
            lace += stones.get(i).toString()+"\n";
        }
        return lace;
    }

    public List<Stone> findStonesByOpacity(double first,double second){
        List<Stone> list = new ArrayList<Stone>();
        for(int i = 0; i < stones.size(); i++){
            if(stones.get(i).getOpacity() <=second && stones.get(i).getOpacity() >= first)
                list.add(stones.get(i));
        }
        return list;
    }
}
