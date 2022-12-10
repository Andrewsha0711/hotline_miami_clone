package maps;

import java.util.ArrayList;

import engine.Loot;
import engine.RectArea;
import npc.Npc;

public interface MapBuilder {

	public ArrayList<RectArea> createArea();
	public ArrayList<Npc> createNpc(int npcCount);
	public ArrayList<Loot> createLoot(int lootCount);
	public Map build();
}
