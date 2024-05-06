import USER_API_ENDPOINTS from "../config";

const handleApiRequest = async (url, options) => {
  const response = await fetch(url, options);
  if (!response.ok) {
    const result = await response.text();
    throw new Error(result);
  }
};

export const deleteUser = async (emailAddress) => {
  return handleApiRequest(
    `${USER_API_ENDPOINTS.DELETE}?emailAddress=${emailAddress}`,
    {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(emailAddress),
    },
  );
};

export const addUser = async (userData) => {
  return handleApiRequest(USER_API_ENDPOINTS.ADD, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(userData),
  });
};

export const getAllUsers = async () => {
  const response = await fetch(USER_API_ENDPOINTS.FIND_ALL);
  if (!response.ok) {
    throw new Error(`Failed to fetch users: ${response.body}`);
  }
  return await response.json();
};
