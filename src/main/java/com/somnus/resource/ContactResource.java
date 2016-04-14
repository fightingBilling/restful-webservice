package com.somnus.resource;

import java.util.List;

import com.somnus.domain.Contact;

/**
 * @description: 
 * Copyright 2011-2016 B5M.COM. All rights reserved
 * @author:  宫柳
 * @version: 1.0
 * @createDate: 2016年4月14日 下午3:56:55 
 * Modification  History:
 * Date         Author        Version        Discription
 * -----------------------------------------------------------------------------------
 * 2016年4月14日       宫柳                               1.0            
 */
public interface ContactResource {
	public List<Contact> addContact(Contact contact);
}
