package fr.utbm.core.entity;

public class JSONResult {
	
	public static final int STATUS_SUCCESS = 0;
	public static final int STATUS_ERROR = 1;
	
	private int _status;
	private String _message;
	private int _idError;
	
	private long _date;
	private String _typeRequest;
	
	private Object _data;
	

	public JSONResult() {
		super();
	}
	
	public void set_status(int status) {
		_status = status;
	}
	public int getStatus() {
		return _status;
	}
	public void set_message(String message) {
		_message = message;
	}
	public String getMessage() {
		return _message;
	}
	
	
	public void set_date(long date) {
		_date = date;
	}
	public long getDate() {
		return _date;
	}
	
	public void set_typeRequest(String typeRequest) {
		_typeRequest = typeRequest;
	}
	public String getTypeRequest() {
		return _typeRequest;
	}
	
	
	public void set_data(Object data) {
		_data = data;
	}
	public Object getData() {
		return _data;
	}
	
	public void set_idError(int idError) {
		_idError = idError;
	}
	
	public void set_error(int idError, String message) {
		_status = STATUS_ERROR;
		_idError = idError;
		_message = message;
	}

	public int getIdError() {
		return _idError;
	}

	public boolean isError() {
		return getStatus() == STATUS_ERROR;
	}

	public boolean isSuccess() {
		return getStatus() == STATUS_SUCCESS;
	}
	
	
	
	
}
