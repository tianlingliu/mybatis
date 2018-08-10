package com.thinkbit.common.sharding;

import java.beans.ConstructorProperties;

public class ShardTable {
    private String prefix;
    private String name;
    private String suffix;

    public static ShardTable buildSuffix(String suffix) {
        ShardTable shardTable = new ShardTable();
        shardTable.setSuffix(suffix);
        return shardTable;
    }

    public static ShardTable.ShardTableBuilder builder() {
        return new ShardTable.ShardTableBuilder();
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getName() {
        return this.name;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ShardTable)) {
            return false;
        } else {
            ShardTable other = (ShardTable) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47:
                {
                    Object this$prefix = this.getPrefix();
                    Object other$prefix = other.getPrefix();
                    if (this$prefix == null) {
                        if (other$prefix == null) {
                            break label47;
                        }
                    } else if (this$prefix.equals(other$prefix)) {
                        break label47;
                    }

                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                Object this$suffix = this.getSuffix();
                Object other$suffix = other.getSuffix();
                if (this$suffix == null) {
                    if (other$suffix != null) {
                        return false;
                    }
                } else if (!this$suffix.equals(other$suffix)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ShardTable;
    }

    public int hashCode() {

        int result = 1;
        Object $prefix = this.getPrefix();
        result = result * 59 + ($prefix == null ? 43 : $prefix.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $suffix = this.getSuffix();
        result = result * 59 + ($suffix == null ? 43 : $suffix.hashCode());
        return result;
    }

    public String toString() {
        return "ShardTable(prefix=" + this.getPrefix() + ", name=" + this.getName() + ", suffix=" + this.getSuffix() + ")";
    }

    @ConstructorProperties({"prefix", "name", "suffix"})
    public ShardTable(String prefix, String name, String suffix) {
        this.prefix = prefix;
        this.name = name;
        this.suffix = suffix;
    }

    public ShardTable() {
    }

    public static class ShardTableBuilder {
        private String prefix;
        private String name;
        private String suffix;

        ShardTableBuilder() {
        }

        public ShardTable.ShardTableBuilder prefix(String prefix) {
            this.prefix = prefix;
            return this;
        }

        public ShardTable.ShardTableBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ShardTable.ShardTableBuilder suffix(String suffix) {
            this.suffix = suffix;
            return this;
        }

        public ShardTable build() {
            return new ShardTable(this.prefix, this.name, this.suffix);
        }

        public String toString() {
            return "ShardTable.ShardTableBuilder(prefix=" + this.prefix + ", name=" + this.name + ", suffix=" + this.suffix + ")";
        }
    }
}

