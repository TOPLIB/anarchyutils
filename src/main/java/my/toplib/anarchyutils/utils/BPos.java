package my.toplib.anarchyutils.utils;

import org.bukkit.Material;

public class BPos {
    private Material block;

    private Vector3 position;

    public BPos(Material block, Vector3 position){
        this.block = block;
        this.position = position;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public Material getBlock() {
        return block;
    }

    public void setBlock(Material block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "BPos{" +
                "block=" + block +
                ", position=" + position +
                '}';
    }
}
