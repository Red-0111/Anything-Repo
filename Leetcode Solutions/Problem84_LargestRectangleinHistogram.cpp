class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
  vector<int>leftsmall(heights.size());
  vector<int>rightsmall(heights.size());
  stack<int>st;
  stack<int>st2;
  st.push(0);
  leftsmall[0] = -1;
  rightsmall[heights.size()-1] = heights.size();
  int ans = INT_MIN;
  for(int i = 1;i < heights.size(); i++)
  {
      while(!st.empty() && heights[st.top()] >= heights[i])
      {
          st.pop();
      }
      if(st.size() == 0)
      {
          leftsmall[i] = -1;
      }else
      {
          leftsmall[i] = st.top();
      }
      st.push(i);
  }
  st2.push(heights.size()-1);
  for(int i = heights.size()-2;i >= 0; i--)
  {
      while(!st2.empty() && heights[st2.top()] >= heights[i])
      {
          st2.pop();
      }
      if(st2.size() == 0)
      {
          rightsmall[i] = heights.size();
      }else
      {
          rightsmall[i] = st2.top();
      }
      st2.push(i);
  }
  for(int i = 0;i < heights.size(); i++)
  {
      int breadth = 1 + (rightsmall[i]-i-1) + (i-leftsmall[i]-1);
      ans = max(ans, heights[i]*breadth);
  }
  return ans;
}
};
