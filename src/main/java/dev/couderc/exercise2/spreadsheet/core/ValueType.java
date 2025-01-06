package dev.couderc.exercise2.spreadsheet.core;

/**
 * Enumeration of available cell types
 * @author J Couderc
 */
public enum ValueType {
    INTEGER {
        @Override
        protected boolean isValidType(String value) {
            try {
                Integer.parseInt(value.trim());
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        @Override
        public String preprocessValue(String value) {
            return value.trim();
        }
    },
    FORMULA {
        @Override
        protected boolean isValidType(String value) {
            return value.startsWith("=");
        }
    },
    STRING {
        @Override
        protected boolean isValidType(String value) {
            // Must always return false to not take precedence over any other type
            return false;
        }
    };

    protected abstract boolean isValidType(String value);

    /**
     * Transforms a value to its cell representation.
     * By default, no transformation is applied, the value is returned as is.
     * @param value The entered value.
     * @return The value in its cell representation.
     */
    public String preprocessValue(String value) {
        return value;
    }

    /**
     * Returns the type of cell associated with the value.
     * If no specific type can be associated to the value, the generic type STRING will be returned.
     * @param value The value to evaluate
     * @return The determined type.
     */
    public static ValueType evaluateValueType(String value) {
        for (ValueType type : ValueType.values()) {
            if (type.isValidType(value)) {
                return type;
            }
        }
        return STRING;
    }
}
