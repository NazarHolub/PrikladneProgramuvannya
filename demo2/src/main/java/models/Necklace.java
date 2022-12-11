package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Necklace{
    int id;
    String name;
    List<Stone> stones;

    public Necklace(Stone stone) {
        this.stones = new ArrayList<Stone>();
    }
    public Necklace(List<Stone> stone) {
        this.stones = stone;
    }

    public Necklace(int id, String name) {
        this.id = id;
        this.name = name;
        this.stones = new ArrayList<Stone>();
    }

    public ObservableList<StoneForTable> getStoneForTable(){
        ObservableList<StoneForTable> list = FXCollections.observableArrayList();
        for (int i = 0; i < stones.size(); i++){
            list.add(new StoneForTable(stones.get(i).id,stones.get(i).name,stones.get(i).carats,
                    stones.get(i).opacity,stones.get(i).price,stones.get(i).color));

        }
        return list;
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
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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
