package com.zipcode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zipcode.utils.DateUtils;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class Listing {
    public Listing() {
        Random rand = new Random();
        mDistance = ((double)rand.nextInt(30)+1)/10.0;
    }
    @JsonProperty("agent")
    private String mAgent;

    @JsonProperty("id")
    private String mId;

    @JsonProperty("mlsListingID")
    private String mMlsListingID;

    @JsonProperty("address")
    private String mAddress;

    @JsonProperty("streetName")
    private String mStreetName;

    @JsonProperty("streetNumber")
    private String mStreetNumber;

    @JsonProperty("city")
    private String mCity;

    @JsonProperty("state")
    private String mState;

    @JsonProperty("county")
    private String mCounty;

    @JsonProperty("country")
    private String mCountry;

    @JsonProperty("zipCode")
    private String mZipCode;

    @JsonProperty("subdivision")
    private String mSubdivision;

    @JsonProperty("latitude")
    private double mLatitude;

    @JsonProperty("longitude")
    private double mLongitude;

    @JsonIgnore
    private Calendar mListDateCal;

    @JsonProperty("listDate")
    public void setListDateCal(String dateString) {
        mListDateCal = DateUtils.getCalendar(dateString);
    }

    @JsonIgnore
    private Calendar mLastModifiedCal;

    @JsonProperty("lastModified")
    public void setLastModifiedCal(String dateString) {
        mLastModifiedCal = DateUtils.getCalendar(dateString);
    }

    @JsonProperty("price")
    private double mPrice;

    @JsonProperty("previousPrice")
    private double mPreviousPrice;

    @JsonProperty("originalPrice")
    private double mOriginalPrice;

    @JsonProperty("closePrice")
    private double mClosePrice;

    @JsonProperty("contingency")
    private String mContingency;

    @JsonProperty("unitsInBuilding")
    private int mUnitsInBuilding;

    @JsonIgnore
    private Calendar mCancelationDateCal;

    @JsonProperty("cancelationDate")
    public void setCancelationDateCal(String dateString) {
        mCancelationDateCal = DateUtils.getCalendar(dateString);
    }

    @JsonIgnore
    private Calendar mExpirationDateCal;

    @JsonProperty("expirationDate")
    public void setExpirationDateCal(String dateString) {
        mExpirationDateCal = DateUtils.getCalendar(dateString);
    }

    @JsonIgnore
    private Calendar mDateListedCal;

    @JsonProperty("dateListed")
    public void setDateListedCal(String dateString) {
        mDateListedCal = DateUtils.getCalendar(dateString);
    }

    @JsonIgnore
    private Calendar mDateSoldCal;

    @JsonProperty("dateSold")
    public void setDateSoldCal(String dateString) {
        mDateSoldCal = DateUtils.getCalendar(dateString);
    }

    @JsonIgnore
    private Calendar mStatusChangeCal;

    @JsonProperty("statusChange")
    public void setStatusChangeCal(String dateString) {
        mStatusChangeCal = DateUtils.getCalendar(dateString);
    }

    @JsonProperty("ownership")
    private String mOwnership;

    @JsonProperty("financialDataSource")
    private String mFinancialDataSource;

    @JsonProperty("yearBuilt")
    private int mYearBuilt;

    @JsonProperty("yearBuiltDetails")
    private String mYearBuiltDetails;

    @JsonProperty("daysOnMarket")
    private int mDaysOnMarket;

    @JsonProperty("waterfront")
    private boolean mIsWaterfront;

    @JsonProperty("zoning")
    private String mZoning;

    @JsonProperty("zoningDescription")
    private String mZoningDescription;

    @JsonProperty("acres")
    private double mAcres;

    @JsonProperty("livingArea")
    private double mLivingArea;

    @JsonProperty("aboveGradeFinishedArea")
    private double mAboveGradeFinishedArea;

    @JsonProperty("belowGradeFinishedArea")
    private double mBelowGradeFinishedArea;

    @JsonProperty("stories")
    private int mStories;

    @JsonProperty("storiesTotal")
    private int mTotalStories;

    @JsonProperty("baths")
    private double mBaths;

    @JsonProperty("halfBaths")
    private int mHalfBaths;

    @JsonProperty("bedrooms")
    private int mBedrooms;

    @JsonProperty("roomsTotal")
    private int mTotalRooms;

    @JsonProperty("fireplaces")
    private int mTotalFireplaces;

    @JsonProperty("frontageLength")
    private double mFrontageLength;

    @JsonProperty("additionalParcels")
    private boolean mHasAdditionalParcels;

    @JsonProperty("occupantType")
    private String mOccupantType;

    @JsonProperty("garageSpaces")
    private int mGarageSpaces;

    @JsonProperty("pool")
    private boolean mIsPoolAvailable;

    @JsonProperty("poolPrivate")
    private boolean mIsPoolPrivate;

    @JsonProperty("roof")
    private String mRoof;

    @JsonProperty("carportSpaces")
    private int mCarportSpaces;

    @JsonProperty("status")
    private String mStatus;

    @JsonProperty("type")
    private String mType;

    @JsonProperty("subtype")
    private String mSubtype;

    @JsonProperty("publicRemarks")
    private String mPublicRemarks;

    @JsonProperty("privateRemarks")
    private String mPrivateRemarks;

    @JsonProperty("taxAssessedValue")
    private String mTaxAssessedValue;

    @JsonProperty("taxAnnual")
    private String mTaxAnnual;

    @JsonProperty("taxYear")
    private String mTaxYear;

    @JsonProperty("vendorID")
    private String mVendorID;

    @JsonProperty("taxStatus")
    private List<String> mTaxStatus;

    @JsonProperty("media")
    private List<Media> mMedia;

    @JsonProperty("laundry")
    private List<String> mLaundry;

    @JsonProperty("sewer")
    private List<String> mSewer;

    @JsonProperty("constructionMaterials")
    private List<String> mConstructionMaterials;

    @JsonProperty("roadSurface")
    private List<String> mRoadSurface;

    @JsonProperty("possession")
    private List<String> mPossession;

    @JsonProperty("poolFeatures")
    private List<String> mPoolFeatures;

    @JsonProperty("heating")
    private List<String> mHeating;

    @JsonProperty("cooling")
    private List<String> mCooling;

    @JsonProperty("accessibilityFeatures")
    private List<String> mAccessibilityFeatures;

    @JsonProperty("gas")
    private List<String> mGas;

    @JsonProperty("foundationDetails")
    private List<String> mFoundationDetails;

    @JsonProperty("flooring")
    private List<String> mFlooring;

    @JsonProperty("exteriorFeatures")
    private List<String> mExteriorFeatures;

    @JsonProperty("fireplaceFeatures")
    private List<String> mFireplaceFeatures;

    @JsonProperty("waterSource")
    private List<String> mWaterSource;

    @JsonProperty("view")
    private List<String> mViews;

    @JsonProperty("telephoneService")
    private List<String> mTelephoneService;

    @JsonProperty("appliances")
    private List<String> mAppliances;

    @JsonProperty("termsOfSale")
    private List<String> mTermsOfSale;

    @JsonProperty("disclosures")
    private List<String> mDisclosures;

    @JsonProperty("mlsOfficeID")
    private String mMlsOfficeID;

    @JsonProperty("office")
    private String mOffice;

    @JsonProperty("mlsAgentID")
    private String mMlsAgentID;

    @JsonProperty("video")
    private Video mVideo;

    @JsonProperty("displayName")
    private String displayName;

    @JsonIgnore
    private boolean mSelected;

    @JsonIgnore
    private double mDistance;

    public double getDistance() {
        return mDistance;
    }

    public boolean isSelected() {
        return mSelected;
    }

    public void setSelected(boolean selected) {
        this.mSelected = selected;
    }

    public String getAgent() {
        return mAgent;
    }

    public void setAgent(String agent) {
        mAgent = agent;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getMlsListingID() {
        return mMlsListingID;
    }

    public void setMlsListingID(String mlsListingID) {
        mMlsListingID = mlsListingID;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getStreetName() {
        return mStreetName;
    }

    public void setStreetName(String streetName) {
        mStreetName = streetName;
    }

    public String getStreetNumber() {
        return mStreetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        mStreetNumber = streetNumber;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getCounty() {
        return mCounty;
    }

    public void setCounty(String county) {
        mCounty = county;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getZipCode() {
        return mZipCode;
    }

    public void setZipCode(String zipCode) {
        mZipCode = zipCode;
    }

    public String getSubdivision() {
        return mSubdivision;
    }

    public void setSubdivision(String subdivision) {
        mSubdivision = subdivision;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

    public Calendar getListDateCal() {
        return mListDateCal;
    }

    public void setListDateCal(Calendar listDateCal) {
        mListDateCal = listDateCal;
    }

    public Calendar getLastModifiedCal() {
        return mLastModifiedCal;
    }

    public void setLastModifiedCal(Calendar lastModifiedCal) {
        mLastModifiedCal = lastModifiedCal;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public double getPreviousPrice() {
        return mPreviousPrice;
    }

    public void setPreviousPrice(double previousPrice) {
        mPreviousPrice = previousPrice;
    }

    public double getOriginalPrice() {
        return mOriginalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        mOriginalPrice = originalPrice;
    }

    public double getClosePrice() {
        return mClosePrice;
    }

    public void setClosePrice(double closePrice) {
        mClosePrice = closePrice;
    }

    public String getContingency() {
        return mContingency;
    }

    public void setContingency(String contingency) {
        mContingency = contingency;
    }

    public int getUnitsInBuilding() {
        return mUnitsInBuilding;
    }

    public void setUnitsInBuilding(int unitsInBuilding) {
        mUnitsInBuilding = unitsInBuilding;
    }

    public Calendar getCancelationDateCal() {
        return mCancelationDateCal;
    }

    public void setCancelationDateCal(Calendar cancelationDateCal) {
        mCancelationDateCal = cancelationDateCal;
    }

    public Calendar getExpirationDateCal() {
        return mExpirationDateCal;
    }

    public void setExpirationDateCal(Calendar expirationDateCal) {
        mExpirationDateCal = expirationDateCal;
    }

    public Calendar getDateListedCal() {
        return mDateListedCal;
    }

    public void setDateListedCal(Calendar dateListedCal) {
        mDateListedCal = dateListedCal;
    }

    public Calendar getDateSoldCal() {
        return mDateSoldCal;
    }

    public void setDateSoldCal(Calendar dateSoldCal) {
        mDateSoldCal = dateSoldCal;
    }

    public Calendar getStatusChangeCal() {
        return mStatusChangeCal;
    }

    public void setStatusChangeCal(Calendar statusChangeCal) {
        mStatusChangeCal = statusChangeCal;
    }

    public String getOwnership() {
        return mOwnership;
    }

    public void setOwnership(String ownership) {
        mOwnership = ownership;
    }

    public String getFinancialDataSource() {
        return mFinancialDataSource;
    }

    public void setFinancialDataSource(String financialDataSource) {
        mFinancialDataSource = financialDataSource;
    }

    public int getYearBuilt() {
        return mYearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        mYearBuilt = yearBuilt;
    }

    public String getYearBuiltDetails() {
        return mYearBuiltDetails;
    }

    public void setYearBuiltDetails(String yearBuiltDetails) {
        mYearBuiltDetails = yearBuiltDetails;
    }

    public int getDaysOnMarket() {
        return mDaysOnMarket;
    }

    public void setDaysOnMarket(int daysOnMarket) {
        mDaysOnMarket = daysOnMarket;
    }

    public boolean isWaterfront() {
        return mIsWaterfront;
    }

    public void setIsWaterfront(boolean isWaterfront) {
        mIsWaterfront = isWaterfront;
    }

    public String getZoning() {
        return mZoning;
    }

    public void setZoning(String zoning) {
        mZoning = zoning;
    }

    public String getZoningDescription() {
        return mZoningDescription;
    }

    public void setZoningDescription(String zoningDescription) {
        mZoningDescription = zoningDescription;
    }

    public double getAcres() {
        return mAcres;
    }

    public void setAcres(double acres) {
        mAcres = acres;
    }

    public double getLivingArea() {
        return mLivingArea;
    }

    public void setLivingArea(double livingArea) {
        mLivingArea = livingArea;
    }

    public double getAboveGradeFinishedArea() {
        return mAboveGradeFinishedArea;
    }

    public void setAboveGradeFinishedArea(double aboveGradeFinishedArea) {
        mAboveGradeFinishedArea = aboveGradeFinishedArea;
    }

    public double getBelowGradeFinishedArea() {
        return mBelowGradeFinishedArea;
    }

    public void setBelowGradeFinishedArea(double belowGradeFinishedArea) {
        mBelowGradeFinishedArea = belowGradeFinishedArea;
    }

    public int getStories() {
        return mStories;
    }

    public void setStories(int stories) {
        mStories = stories;
    }

    public int getTotalStories() {
        return mTotalStories;
    }

    public void setTotalStories(int totalStories) {
        mTotalStories = totalStories;
    }

    public int getHalfBaths() {
        return mHalfBaths;
    }

    public void setHalfBaths(int halfBaths) {
        mHalfBaths = halfBaths;
    }

    public int getBedrooms() {
        return mBedrooms;
    }

    public void setBedrooms(int bedrooms) {
        mBedrooms = bedrooms;
    }

    public int getTotalRooms() {
        return mTotalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        mTotalRooms = totalRooms;
    }

    public int getTotalFireplaces() {
        return mTotalFireplaces;
    }

    public void setTotalFireplaces(int totalFireplaces) {
        mTotalFireplaces = totalFireplaces;
    }

    public double getFrontageLength() {
        return mFrontageLength;
    }

    public void setFrontageLength(double frontageLength) {
        mFrontageLength = frontageLength;
    }

    public boolean isHasAdditionalParcels() {
        return mHasAdditionalParcels;
    }

    public void setHasAdditionalParcels(boolean hasAdditionalParcels) {
        mHasAdditionalParcels = hasAdditionalParcels;
    }

    public String getOccupantType() {
        return mOccupantType;
    }

    public void setOccupantType(String occupantType) {
        mOccupantType = occupantType;
    }

    public int getGarageSpaces() {
        return mGarageSpaces;
    }

    public void setGarageSpaces(int garageSpaces) {
        mGarageSpaces = garageSpaces;
    }

    public boolean isPoolAvailable() {
        return mIsPoolAvailable;
    }

    public void setIsPoolAvailable(boolean isPoolAvailable) {
        mIsPoolAvailable = isPoolAvailable;
    }

    public boolean isPoolPrivate() {
        return mIsPoolPrivate;
    }

    public void setIsPoolPrivate(boolean isPoolPrivate) {
        mIsPoolPrivate = isPoolPrivate;
    }

    public String getRoof() {
        return mRoof;
    }

    public void setRoof(String roof) {
        mRoof = roof;
    }

    public int getCarportSpaces() {
        return mCarportSpaces;
    }

    public void setCarportSpaces(int carportSpaces) {
        mCarportSpaces = carportSpaces;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getSubtype() {
        return mSubtype;
    }

    public void setSubtype(String subtype) {
        mSubtype = subtype;
    }

    public String getPublicRemarks() {
        return mPublicRemarks;
    }

    public void setPublicRemarks(String publicRemarks) {
        mPublicRemarks = publicRemarks;
    }

    public String getPrivateRemarks() {
        return mPrivateRemarks;
    }

    public void setPrivateRemarks(String privateRemarks) {
        mPrivateRemarks = privateRemarks;
    }

    public String getTaxAssessedValue() {
        return mTaxAssessedValue;
    }

    public void setTaxAssessedValue(String taxAssessedValue) {
        mTaxAssessedValue = taxAssessedValue;
    }

    public String getTaxAnnual() {
        return mTaxAnnual;
    }

    public void setTaxAnnual(String taxAnnual) {
        mTaxAnnual = taxAnnual;
    }

    public String getTaxYear() {
        return mTaxYear;
    }

    public void setTaxYear(String taxYear) {
        mTaxYear = taxYear;
    }

    public String getVendorID() {
        return mVendorID;
    }

    public void setVendorID(String vendorID) {
        mVendorID = vendorID;
    }

    public List<String> getTaxStatus() {
        return mTaxStatus;
    }

    public void setTaxStatus(List<String> taxStatus) {
        mTaxStatus = taxStatus;
    }

    public List<Media> getMedia() {
        return mMedia;
    }

    public void setMedia(List<Media> media) {
        mMedia = media;
    }

    public List<String> getLaundry() {
        return mLaundry;
    }

    public void setLaundry(List<String> laundry) {
        mLaundry = laundry;
    }

    public List<String> getSewer() {
        return mSewer;
    }

    public void setSewer(List<String> sewer) {
        mSewer = sewer;
    }

    public List<String> getConstructionMaterials() {
        return mConstructionMaterials;
    }

    public void setConstructionMaterials(List<String> constructionMaterials) {
        mConstructionMaterials = constructionMaterials;
    }

    public List<String> getRoadSurface() {
        return mRoadSurface;
    }

    public void setRoadSurface(List<String> roadSurface) {
        mRoadSurface = roadSurface;
    }

    public List<String> getPossession() {
        return mPossession;
    }

    public void setPossession(List<String> possession) {
        mPossession = possession;
    }

    public List<String> getPoolFeatures() {
        return mPoolFeatures;
    }

    public void setPoolFeatures(List<String> poolFeatures) {
        mPoolFeatures = poolFeatures;
    }

    public List<String> getHeating() {
        return mHeating;
    }

    public void setHeating(List<String> heating) {
        mHeating = heating;
    }

    public List<String> getCooling() {
        return mCooling;
    }

    public void setCooling(List<String> cooling) {
        mCooling = cooling;
    }

    public List<String> getAccessibilityFeatures() {
        return mAccessibilityFeatures;
    }

    public void setAccessibilityFeatures(List<String> accessibilityFeatures) {
        mAccessibilityFeatures = accessibilityFeatures;
    }

    public List<String> getGas() {
        return mGas;
    }

    public void setGas(List<String> gas) {
        mGas = gas;
    }

    public List<String> getFoundationDetails() {
        return mFoundationDetails;
    }

    public void setFoundationDetails(List<String> foundationDetails) {
        mFoundationDetails = foundationDetails;
    }

    public List<String> getFlooring() {
        return mFlooring;
    }

    public void setFlooring(List<String> flooring) {
        mFlooring = flooring;
    }

    public List<String> getExteriorFeatures() {
        return mExteriorFeatures;
    }

    public void setExteriorFeatures(List<String> exteriorFeatures) {
        mExteriorFeatures = exteriorFeatures;
    }

    public List<String> getFireplaceFeatures() {
        return mFireplaceFeatures;
    }

    public void setFireplaceFeatures(List<String> fireplaceFeatures) {
        mFireplaceFeatures = fireplaceFeatures;
    }

    public List<String> getWaterSource() {
        return mWaterSource;
    }

    public void setWaterSource(List<String> waterSource) {
        mWaterSource = waterSource;
    }

    public List<String> getViews() {
        return mViews;
    }

    public void setViews(List<String> views) {
        mViews = views;
    }

    public List<String> getTelephoneService() {
        return mTelephoneService;
    }

    public void setTelephoneService(List<String> telephoneService) {
        mTelephoneService = telephoneService;
    }

    public List<String> getAppliances() {
        return mAppliances;
    }

    public void setAppliances(List<String> appliances) {
        mAppliances = appliances;
    }

    public List<String> getTermsOfSale() {
        return mTermsOfSale;
    }

    public void setTermsOfSale(List<String> termsOfSale) {
        mTermsOfSale = termsOfSale;
    }

    public List<String> getDisclosures() {
        return mDisclosures;
    }

    public void setDisclosures(List<String> disclosures) {
        mDisclosures = disclosures;
    }

    public String getMlsOfficeID() {
        return mMlsOfficeID;
    }

    public void setMlsOfficeID(String mlsOfficeID) {
        mMlsOfficeID = mlsOfficeID;
    }

    public String getOffice() {
        return mOffice;
    }

    public void setOffice(String office) {
        mOffice = office;
    }

    public String getMlsAgentID() {
        return mMlsAgentID;
    }

    public void setMlsAgentID(String mlsAgentID) {
        mMlsAgentID = mlsAgentID;
    }

    public Video getVideo() {
        return mVideo;
    }

    public void setVideo(Video video) {
        mVideo = video;
    }

    public double getBaths() {
        return mBaths;
    }

    public void setBaths(double baths) {
        mBaths = baths;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}
