package checkbox_treetable;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Node<T> {
	private T data;

	private ArrayList<String> dataToDisplay;

	public Node(T data) {
		this.data = data;
		dataToDisplay = new ArrayList<>();
		// loadValuesToDisplay();
	}

	public void loadValuesToDisplayFromAnnotation() {

		Field[] fields = data.getClass().getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(ToDisplay.class)) {
				field.setAccessible(true);
				try {
					Settings.addVariableToDisplay(field.getName());
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void checkIfNodeContainsValuesToDisplay() {

		for (String fieldName : Settings.variablesToDisplay) {

			Class<?> someClass = data.getClass();
			Field someField = null;

			while (someClass != null && someField == null) {

				try {
					someField = someClass.getDeclaredField(fieldName);
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				someClass = someClass.getSuperclass();
			}

			if (someField == null) {
				Settings.addInvalidVariablesToDisplay(fieldName);
			}
		}
	}

	public void loadValuesToDisplay() {

		for (String fieldName : Settings.variablesToDisplay) {

			Object value = null;
			Class<?> someClass = data.getClass();
			Field someField = null;

			while (someClass != null && someField == null) {

				try {
					someField = someClass.getDeclaredField(fieldName);
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				someClass = someClass.getSuperclass();
			}

			if (someField != null) {

				someField.setAccessible(true);

				try {
					value = someField.get((Object) data);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				dataToDisplay.add(value.toString());
			}
		}

	}

	public int getDataToDisplaySize() {
		return dataToDisplay.size();
	}

	public String getData(int idx) {
		return dataToDisplay.get(idx);
	}

}
