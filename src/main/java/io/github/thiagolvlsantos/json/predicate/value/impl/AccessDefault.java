package io.github.thiagolvlsantos.json.predicate.value.impl;

import java.util.Map;

//import org.apache.commons.beanutils.NestedNullException;
//import org.apache.commons.beanutils.PropertyUtils;

import cn.hutool.core.bean.BeanUtil;
import io.github.thiagolvlsantos.json.predicate.value.IAccess;
//import org.apache.commons.beanutils.NestedNullException;
//import org.apache.commons.beanutils.PropertyUtils;
//import org.apache.commons.beanutils.NestedNullException;
//import org.apache.commons.beanutils.PropertyUtils;

public class AccessDefault implements IAccess {

	@SuppressWarnings("unchecked")
	@Override
//	public Object get(Object source, String path) {
//		try {
//			return PropertyUtils.getProperty(source, path);
//		} catch (NestedNullException e) {
//			return null;
//		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//			throw new JsonPredicateException(e.getMessage(), e);
//		}
//	}

	public Object get(Object source, String path) {
		// 优先从当前对象获取key，在从下级获取key
		if (source instanceof Map) {
			Map<String, Object> map = (Map<String, Object>) source;
			// 只有source 是map的时候，才会出现key是xxx.ab的形式
			// 支持扁平格式的写法
			Object obj = map.get(path);
			if (obj != null) {
				return obj;
			}
		}
		return BeanUtil.getProperty(source, path);
	}

}