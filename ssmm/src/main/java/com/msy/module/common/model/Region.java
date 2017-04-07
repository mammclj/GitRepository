package com.msy.module.common.model;

public class Region {
    private String regionId;

    private String region;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

	public Region(String regionId, String region) {
		super();
		this.regionId = regionId;
		this.region = region;
	}

	public Region() {
		super();
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", region=" + region + "]";
	}
    
    
    
}