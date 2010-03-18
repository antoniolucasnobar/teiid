/*
 * JBoss, Home of Professional Open Source.
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 */

package com.metamatrix.dqp.client;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;

import com.metamatrix.core.util.ExternalizeUtil;

public class MetadataResult implements Externalizable {
	private static final long serialVersionUID = -1520482281079030324L;
	private Map[] columnMetadata;
	private Map[] parameterMetadata;
	
	public MetadataResult() {
	}
	
	public MetadataResult(Map[] columnMetadata, Map[] parameterMetadata) {
		super();
		this.columnMetadata = columnMetadata;
		this.parameterMetadata = parameterMetadata;
	}
	public Map[] getColumnMetadata() {
		return columnMetadata;
	}
	
	public Map[] getParameterMetadata() {
		return parameterMetadata;
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		columnMetadata = ExternalizeUtil.readArray(in, Map.class);
		parameterMetadata = ExternalizeUtil.readArray(in, Map.class);
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		ExternalizeUtil.writeArray(out, columnMetadata);
		ExternalizeUtil.writeArray(out, parameterMetadata);
	}
	
}
