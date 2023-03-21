package model.world;

import model.collectibles.Collectible;

public class CollectibleCell extends Cell {
public CollectibleCell(Collectible collectible) {
		super();
		this.collectible = collectible;
	}

private Collectible collectible;

public Collectible getCollectible() {
	return collectible;
}
}
