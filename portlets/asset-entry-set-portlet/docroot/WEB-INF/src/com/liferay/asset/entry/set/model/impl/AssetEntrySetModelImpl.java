/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.asset.entry.set.model.impl;

import com.liferay.asset.entry.set.model.AssetEntrySet;
import com.liferay.asset.entry.set.model.AssetEntrySetModel;
import com.liferay.asset.entry.set.model.AssetEntrySetSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the AssetEntrySet service. Represents a row in the &quot;AssetEntrySet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.asset.entry.set.model.AssetEntrySetModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AssetEntrySetImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetEntrySetImpl
 * @see com.liferay.asset.entry.set.model.AssetEntrySet
 * @see com.liferay.asset.entry.set.model.AssetEntrySetModel
 * @generated
 */
@JSON(strict = true)
public class AssetEntrySetModelImpl extends BaseModelImpl<AssetEntrySet>
	implements AssetEntrySetModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a asset entry set model instance should use the {@link com.liferay.asset.entry.set.model.AssetEntrySet} interface instead.
	 */
	public static final String TABLE_NAME = "AssetEntrySet";
	public static final Object[][] TABLE_COLUMNS = {
			{ "assetEntrySetId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createTime", Types.BIGINT },
			{ "modifiedTime", Types.BIGINT },
			{ "assetEntryId", Types.BIGINT },
			{ "parentAssetEntrySetId", Types.BIGINT },
			{ "classNameId", Types.BIGINT },
			{ "classPK", Types.BIGINT },
			{ "creatorClassNameId", Types.BIGINT },
			{ "creatorClassPK", Types.BIGINT },
			{ "creatorName", Types.VARCHAR },
			{ "assetEntrySetLikesCount", Types.INTEGER },
			{ "childAssetEntrySetsCount", Types.INTEGER },
			{ "level", Types.INTEGER },
			{ "payload", Types.VARCHAR },
			{ "privateAssetEntrySet", Types.BOOLEAN },
			{ "stickyTime", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "type_", Types.INTEGER },
			{ "status", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table AssetEntrySet (assetEntrySetId LONG not null primary key,companyId LONG,userId LONG,createTime LONG,modifiedTime LONG,assetEntryId LONG,parentAssetEntrySetId LONG,classNameId LONG,classPK LONG,creatorClassNameId LONG,creatorClassPK LONG,creatorName VARCHAR(75) null,assetEntrySetLikesCount INTEGER,childAssetEntrySetsCount INTEGER,level INTEGER,payload STRING null,privateAssetEntrySet BOOLEAN,stickyTime LONG,title VARCHAR(255) null,type_ INTEGER,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table AssetEntrySet";
	public static final String ORDER_BY_JPQL = " ORDER BY assetEntrySet.createTime DESC";
	public static final String ORDER_BY_SQL = " ORDER BY AssetEntrySet.createTime DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.asset.entry.set.model.AssetEntrySet"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.asset.entry.set.model.AssetEntrySet"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.asset.entry.set.model.AssetEntrySet"),
			true);
	public static long CLASSNAMEID_COLUMN_BITMASK = 1L;
	public static long CLASSPK_COLUMN_BITMASK = 2L;
	public static long CREATETIME_COLUMN_BITMASK = 4L;
	public static long CREATORCLASSNAMEID_COLUMN_BITMASK = 8L;
	public static long CREATORCLASSPK_COLUMN_BITMASK = 16L;
	public static long PARENTASSETENTRYSETID_COLUMN_BITMASK = 32L;
	public static long TITLE_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AssetEntrySet toModel(AssetEntrySetSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AssetEntrySet model = new AssetEntrySetImpl();

		model.setAssetEntrySetId(soapModel.getAssetEntrySetId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreateTime(soapModel.getCreateTime());
		model.setModifiedTime(soapModel.getModifiedTime());
		model.setAssetEntryId(soapModel.getAssetEntryId());
		model.setParentAssetEntrySetId(soapModel.getParentAssetEntrySetId());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setCreatorClassNameId(soapModel.getCreatorClassNameId());
		model.setCreatorClassPK(soapModel.getCreatorClassPK());
		model.setCreatorName(soapModel.getCreatorName());
		model.setAssetEntrySetLikesCount(soapModel.getAssetEntrySetLikesCount());
		model.setChildAssetEntrySetsCount(soapModel.getChildAssetEntrySetsCount());
		model.setLevel(soapModel.getLevel());
		model.setPayload(soapModel.getPayload());
		model.setPrivateAssetEntrySet(soapModel.getPrivateAssetEntrySet());
		model.setStickyTime(soapModel.getStickyTime());
		model.setTitle(soapModel.getTitle());
		model.setType(soapModel.getType());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AssetEntrySet> toModels(AssetEntrySetSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AssetEntrySet> models = new ArrayList<AssetEntrySet>(soapModels.length);

		for (AssetEntrySetSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.asset.entry.set.model.AssetEntrySet"));

	public AssetEntrySetModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _assetEntrySetId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAssetEntrySetId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _assetEntrySetId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AssetEntrySet.class;
	}

	@Override
	public String getModelClassName() {
		return AssetEntrySet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("assetEntrySetId", getAssetEntrySetId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("assetEntryId", getAssetEntryId());
		attributes.put("parentAssetEntrySetId", getParentAssetEntrySetId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("creatorClassNameId", getCreatorClassNameId());
		attributes.put("creatorClassPK", getCreatorClassPK());
		attributes.put("creatorName", getCreatorName());
		attributes.put("assetEntrySetLikesCount", getAssetEntrySetLikesCount());
		attributes.put("childAssetEntrySetsCount", getChildAssetEntrySetsCount());
		attributes.put("level", getLevel());
		attributes.put("payload", getPayload());
		attributes.put("privateAssetEntrySet", getPrivateAssetEntrySet());
		attributes.put("stickyTime", getStickyTime());
		attributes.put("title", getTitle());
		attributes.put("type", getType());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long assetEntrySetId = (Long)attributes.get("assetEntrySetId");

		if (assetEntrySetId != null) {
			setAssetEntrySetId(assetEntrySetId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long createTime = (Long)attributes.get("createTime");

		if (createTime != null) {
			setCreateTime(createTime);
		}

		Long modifiedTime = (Long)attributes.get("modifiedTime");

		if (modifiedTime != null) {
			setModifiedTime(modifiedTime);
		}

		Long assetEntryId = (Long)attributes.get("assetEntryId");

		if (assetEntryId != null) {
			setAssetEntryId(assetEntryId);
		}

		Long parentAssetEntrySetId = (Long)attributes.get(
				"parentAssetEntrySetId");

		if (parentAssetEntrySetId != null) {
			setParentAssetEntrySetId(parentAssetEntrySetId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Long creatorClassNameId = (Long)attributes.get("creatorClassNameId");

		if (creatorClassNameId != null) {
			setCreatorClassNameId(creatorClassNameId);
		}

		Long creatorClassPK = (Long)attributes.get("creatorClassPK");

		if (creatorClassPK != null) {
			setCreatorClassPK(creatorClassPK);
		}

		String creatorName = (String)attributes.get("creatorName");

		if (creatorName != null) {
			setCreatorName(creatorName);
		}

		Integer assetEntrySetLikesCount = (Integer)attributes.get(
				"assetEntrySetLikesCount");

		if (assetEntrySetLikesCount != null) {
			setAssetEntrySetLikesCount(assetEntrySetLikesCount);
		}

		Integer childAssetEntrySetsCount = (Integer)attributes.get(
				"childAssetEntrySetsCount");

		if (childAssetEntrySetsCount != null) {
			setChildAssetEntrySetsCount(childAssetEntrySetsCount);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		String payload = (String)attributes.get("payload");

		if (payload != null) {
			setPayload(payload);
		}

		Boolean privateAssetEntrySet = (Boolean)attributes.get(
				"privateAssetEntrySet");

		if (privateAssetEntrySet != null) {
			setPrivateAssetEntrySet(privateAssetEntrySet);
		}

		Long stickyTime = (Long)attributes.get("stickyTime");

		if (stickyTime != null) {
			setStickyTime(stickyTime);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@JSON
	@Override
	public long getAssetEntrySetId() {
		return _assetEntrySetId;
	}

	@Override
	public void setAssetEntrySetId(long assetEntrySetId) {
		_assetEntrySetId = assetEntrySetId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public long getCreateTime() {
		return _createTime;
	}

	@Override
	public void setCreateTime(long createTime) {
		_columnBitmask = -1L;

		if (!_setOriginalCreateTime) {
			_setOriginalCreateTime = true;

			_originalCreateTime = _createTime;
		}

		_createTime = createTime;
	}

	public long getOriginalCreateTime() {
		return _originalCreateTime;
	}

	@JSON
	@Override
	public long getModifiedTime() {
		return _modifiedTime;
	}

	@Override
	public void setModifiedTime(long modifiedTime) {
		_modifiedTime = modifiedTime;
	}

	@JSON
	@Override
	public long getAssetEntryId() {
		return _assetEntryId;
	}

	@Override
	public void setAssetEntryId(long assetEntryId) {
		_assetEntryId = assetEntryId;
	}

	@JSON
	@Override
	public long getParentAssetEntrySetId() {
		return _parentAssetEntrySetId;
	}

	@Override
	public void setParentAssetEntrySetId(long parentAssetEntrySetId) {
		_columnBitmask |= PARENTASSETENTRYSETID_COLUMN_BITMASK;

		if (!_setOriginalParentAssetEntrySetId) {
			_setOriginalParentAssetEntrySetId = true;

			_originalParentAssetEntrySetId = _parentAssetEntrySetId;
		}

		_parentAssetEntrySetId = parentAssetEntrySetId;
	}

	public long getOriginalParentAssetEntrySetId() {
		return _originalParentAssetEntrySetId;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return StringPool.BLANK;
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@JSON
	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@JSON
	@Override
	public long getCreatorClassNameId() {
		return _creatorClassNameId;
	}

	@Override
	public void setCreatorClassNameId(long creatorClassNameId) {
		_columnBitmask |= CREATORCLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalCreatorClassNameId) {
			_setOriginalCreatorClassNameId = true;

			_originalCreatorClassNameId = _creatorClassNameId;
		}

		_creatorClassNameId = creatorClassNameId;
	}

	public long getOriginalCreatorClassNameId() {
		return _originalCreatorClassNameId;
	}

	@JSON
	@Override
	public long getCreatorClassPK() {
		return _creatorClassPK;
	}

	@Override
	public void setCreatorClassPK(long creatorClassPK) {
		_columnBitmask |= CREATORCLASSPK_COLUMN_BITMASK;

		if (!_setOriginalCreatorClassPK) {
			_setOriginalCreatorClassPK = true;

			_originalCreatorClassPK = _creatorClassPK;
		}

		_creatorClassPK = creatorClassPK;
	}

	public long getOriginalCreatorClassPK() {
		return _originalCreatorClassPK;
	}

	@JSON
	@Override
	public String getCreatorName() {
		if (_creatorName == null) {
			return StringPool.BLANK;
		}
		else {
			return _creatorName;
		}
	}

	@Override
	public void setCreatorName(String creatorName) {
		_creatorName = creatorName;
	}

	@JSON
	@Override
	public int getAssetEntrySetLikesCount() {
		return _assetEntrySetLikesCount;
	}

	@Override
	public void setAssetEntrySetLikesCount(int assetEntrySetLikesCount) {
		_assetEntrySetLikesCount = assetEntrySetLikesCount;
	}

	@JSON
	@Override
	public int getChildAssetEntrySetsCount() {
		return _childAssetEntrySetsCount;
	}

	@Override
	public void setChildAssetEntrySetsCount(int childAssetEntrySetsCount) {
		_childAssetEntrySetsCount = childAssetEntrySetsCount;
	}

	@JSON
	@Override
	public int getLevel() {
		return _level;
	}

	@Override
	public void setLevel(int level) {
		_level = level;
	}

	@JSON
	@Override
	public String getPayload() {
		if (_payload == null) {
			return StringPool.BLANK;
		}
		else {
			return _payload;
		}
	}

	@Override
	public void setPayload(String payload) {
		_payload = payload;
	}

	@JSON
	@Override
	public boolean getPrivateAssetEntrySet() {
		return _privateAssetEntrySet;
	}

	@Override
	public boolean isPrivateAssetEntrySet() {
		return _privateAssetEntrySet;
	}

	@Override
	public void setPrivateAssetEntrySet(boolean privateAssetEntrySet) {
		_privateAssetEntrySet = privateAssetEntrySet;
	}

	@JSON
	@Override
	public long getStickyTime() {
		return _stickyTime;
	}

	@Override
	public void setStickyTime(long stickyTime) {
		_stickyTime = stickyTime;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_columnBitmask |= TITLE_COLUMN_BITMASK;

		if (_originalTitle == null) {
			_originalTitle = _title;
		}

		_title = title;
	}

	public String getOriginalTitle() {
		return GetterUtil.getString(_originalTitle);
	}

	@JSON
	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_type = type;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			AssetEntrySet.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AssetEntrySet toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AssetEntrySet)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AssetEntrySetImpl assetEntrySetImpl = new AssetEntrySetImpl();

		assetEntrySetImpl.setAssetEntrySetId(getAssetEntrySetId());
		assetEntrySetImpl.setCompanyId(getCompanyId());
		assetEntrySetImpl.setUserId(getUserId());
		assetEntrySetImpl.setCreateTime(getCreateTime());
		assetEntrySetImpl.setModifiedTime(getModifiedTime());
		assetEntrySetImpl.setAssetEntryId(getAssetEntryId());
		assetEntrySetImpl.setParentAssetEntrySetId(getParentAssetEntrySetId());
		assetEntrySetImpl.setClassNameId(getClassNameId());
		assetEntrySetImpl.setClassPK(getClassPK());
		assetEntrySetImpl.setCreatorClassNameId(getCreatorClassNameId());
		assetEntrySetImpl.setCreatorClassPK(getCreatorClassPK());
		assetEntrySetImpl.setCreatorName(getCreatorName());
		assetEntrySetImpl.setAssetEntrySetLikesCount(getAssetEntrySetLikesCount());
		assetEntrySetImpl.setChildAssetEntrySetsCount(getChildAssetEntrySetsCount());
		assetEntrySetImpl.setLevel(getLevel());
		assetEntrySetImpl.setPayload(getPayload());
		assetEntrySetImpl.setPrivateAssetEntrySet(getPrivateAssetEntrySet());
		assetEntrySetImpl.setStickyTime(getStickyTime());
		assetEntrySetImpl.setTitle(getTitle());
		assetEntrySetImpl.setType(getType());
		assetEntrySetImpl.setStatus(getStatus());

		assetEntrySetImpl.resetOriginalValues();

		return assetEntrySetImpl;
	}

	@Override
	public int compareTo(AssetEntrySet assetEntrySet) {
		int value = 0;

		if (getCreateTime() < assetEntrySet.getCreateTime()) {
			value = -1;
		}
		else if (getCreateTime() > assetEntrySet.getCreateTime()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssetEntrySet)) {
			return false;
		}

		AssetEntrySet assetEntrySet = (AssetEntrySet)obj;

		long primaryKey = assetEntrySet.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		AssetEntrySetModelImpl assetEntrySetModelImpl = this;

		assetEntrySetModelImpl._originalCreateTime = assetEntrySetModelImpl._createTime;

		assetEntrySetModelImpl._setOriginalCreateTime = false;

		assetEntrySetModelImpl._originalParentAssetEntrySetId = assetEntrySetModelImpl._parentAssetEntrySetId;

		assetEntrySetModelImpl._setOriginalParentAssetEntrySetId = false;

		assetEntrySetModelImpl._originalClassNameId = assetEntrySetModelImpl._classNameId;

		assetEntrySetModelImpl._setOriginalClassNameId = false;

		assetEntrySetModelImpl._originalClassPK = assetEntrySetModelImpl._classPK;

		assetEntrySetModelImpl._setOriginalClassPK = false;

		assetEntrySetModelImpl._originalCreatorClassNameId = assetEntrySetModelImpl._creatorClassNameId;

		assetEntrySetModelImpl._setOriginalCreatorClassNameId = false;

		assetEntrySetModelImpl._originalCreatorClassPK = assetEntrySetModelImpl._creatorClassPK;

		assetEntrySetModelImpl._setOriginalCreatorClassPK = false;

		assetEntrySetModelImpl._originalTitle = assetEntrySetModelImpl._title;

		assetEntrySetModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AssetEntrySet> toCacheModel() {
		AssetEntrySetCacheModel assetEntrySetCacheModel = new AssetEntrySetCacheModel();

		assetEntrySetCacheModel.assetEntrySetId = getAssetEntrySetId();

		assetEntrySetCacheModel.companyId = getCompanyId();

		assetEntrySetCacheModel.userId = getUserId();

		assetEntrySetCacheModel.createTime = getCreateTime();

		assetEntrySetCacheModel.modifiedTime = getModifiedTime();

		assetEntrySetCacheModel.assetEntryId = getAssetEntryId();

		assetEntrySetCacheModel.parentAssetEntrySetId = getParentAssetEntrySetId();

		assetEntrySetCacheModel.classNameId = getClassNameId();

		assetEntrySetCacheModel.classPK = getClassPK();

		assetEntrySetCacheModel.creatorClassNameId = getCreatorClassNameId();

		assetEntrySetCacheModel.creatorClassPK = getCreatorClassPK();

		assetEntrySetCacheModel.creatorName = getCreatorName();

		String creatorName = assetEntrySetCacheModel.creatorName;

		if ((creatorName != null) && (creatorName.length() == 0)) {
			assetEntrySetCacheModel.creatorName = null;
		}

		assetEntrySetCacheModel.assetEntrySetLikesCount = getAssetEntrySetLikesCount();

		assetEntrySetCacheModel.childAssetEntrySetsCount = getChildAssetEntrySetsCount();

		assetEntrySetCacheModel.level = getLevel();

		assetEntrySetCacheModel.payload = getPayload();

		String payload = assetEntrySetCacheModel.payload;

		if ((payload != null) && (payload.length() == 0)) {
			assetEntrySetCacheModel.payload = null;
		}

		assetEntrySetCacheModel.privateAssetEntrySet = getPrivateAssetEntrySet();

		assetEntrySetCacheModel.stickyTime = getStickyTime();

		assetEntrySetCacheModel.title = getTitle();

		String title = assetEntrySetCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			assetEntrySetCacheModel.title = null;
		}

		assetEntrySetCacheModel.type = getType();

		assetEntrySetCacheModel.status = getStatus();

		return assetEntrySetCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{assetEntrySetId=");
		sb.append(getAssetEntrySetId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createTime=");
		sb.append(getCreateTime());
		sb.append(", modifiedTime=");
		sb.append(getModifiedTime());
		sb.append(", assetEntryId=");
		sb.append(getAssetEntryId());
		sb.append(", parentAssetEntrySetId=");
		sb.append(getParentAssetEntrySetId());
		sb.append(", classNameId=");
		sb.append(getClassNameId());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", creatorClassNameId=");
		sb.append(getCreatorClassNameId());
		sb.append(", creatorClassPK=");
		sb.append(getCreatorClassPK());
		sb.append(", creatorName=");
		sb.append(getCreatorName());
		sb.append(", assetEntrySetLikesCount=");
		sb.append(getAssetEntrySetLikesCount());
		sb.append(", childAssetEntrySetsCount=");
		sb.append(getChildAssetEntrySetsCount());
		sb.append(", level=");
		sb.append(getLevel());
		sb.append(", payload=");
		sb.append(getPayload());
		sb.append(", privateAssetEntrySet=");
		sb.append(getPrivateAssetEntrySet());
		sb.append(", stickyTime=");
		sb.append(getStickyTime());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("com.liferay.asset.entry.set.model.AssetEntrySet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>assetEntrySetId</column-name><column-value><![CDATA[");
		sb.append(getAssetEntrySetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createTime</column-name><column-value><![CDATA[");
		sb.append(getCreateTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedTime</column-name><column-value><![CDATA[");
		sb.append(getModifiedTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assetEntryId</column-name><column-value><![CDATA[");
		sb.append(getAssetEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentAssetEntrySetId</column-name><column-value><![CDATA[");
		sb.append(getParentAssetEntrySetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classNameId</column-name><column-value><![CDATA[");
		sb.append(getClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creatorClassNameId</column-name><column-value><![CDATA[");
		sb.append(getCreatorClassNameId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creatorClassPK</column-name><column-value><![CDATA[");
		sb.append(getCreatorClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creatorName</column-name><column-value><![CDATA[");
		sb.append(getCreatorName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assetEntrySetLikesCount</column-name><column-value><![CDATA[");
		sb.append(getAssetEntrySetLikesCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>childAssetEntrySetsCount</column-name><column-value><![CDATA[");
		sb.append(getChildAssetEntrySetsCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level</column-name><column-value><![CDATA[");
		sb.append(getLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>payload</column-name><column-value><![CDATA[");
		sb.append(getPayload());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>privateAssetEntrySet</column-name><column-value><![CDATA[");
		sb.append(getPrivateAssetEntrySet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stickyTime</column-name><column-value><![CDATA[");
		sb.append(getStickyTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = AssetEntrySet.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			AssetEntrySet.class
		};
	private long _assetEntrySetId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private long _createTime;
	private long _originalCreateTime;
	private boolean _setOriginalCreateTime;
	private long _modifiedTime;
	private long _assetEntryId;
	private long _parentAssetEntrySetId;
	private long _originalParentAssetEntrySetId;
	private boolean _setOriginalParentAssetEntrySetId;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private long _creatorClassNameId;
	private long _originalCreatorClassNameId;
	private boolean _setOriginalCreatorClassNameId;
	private long _creatorClassPK;
	private long _originalCreatorClassPK;
	private boolean _setOriginalCreatorClassPK;
	private String _creatorName;
	private int _assetEntrySetLikesCount;
	private int _childAssetEntrySetsCount;
	private int _level;
	private String _payload;
	private boolean _privateAssetEntrySet;
	private long _stickyTime;
	private String _title;
	private String _originalTitle;
	private int _type;
	private int _status;
	private long _columnBitmask;
	private AssetEntrySet _escapedModel;
}