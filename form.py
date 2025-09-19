import re

# Validation functions
def validate_username(username):
    if not username:
        return False, "Username cannot be empty."
    if len(username) < 3:
        return False, "Username must be at least 3 characters."
    if not re.match(r'^[a-zA-Z0-9_]+$', username):
        return False, "Username can only contain letters, numbers, and underscores."
    return True, ""

def validate_email(email):
    if not email:
        return False, "Email cannot be empty."
    # Simple regex for email validation
    if not re.match(r'^[\w\.-]+@[\w\.-]+\.\w+$', email):
        return False, "Invalid email format."
    return True, ""

def validate_password(password):
    if len(password) < 8:
        return False, "Password must be at least 8 characters."
    if not re.search(r'[A-Z]', password):
        return False, "Password must contain at least one uppercase letter."
    if not re.search(r'[a-z]', password):
        return False, "Password must contain at least one lowercase letter."
    if not re.search(r'[0-9]', password):
        return False, "Password must contain at least one digit."
    if not re.search(r'[\W_]', password):
        return False, "Password must contain at least one special character."
    return True, ""

def confirm_password(password, confirm):
    if password != confirm:
        return False, "Passwords do not match."
    return True, ""

# Signup pipeline
def signup_pipeline(data):
    valid
