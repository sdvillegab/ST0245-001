class Date():
    """Representation of a date and its operations"""

    def __init__(self, day, month, year):
        self.day = day
        self.month = month
        self.year = year

    def get_day(self): 
        return self.day


    def get_month(self): 
        return self.month

    def get_year(self): 
        return self.year
 
    def compare(self,other):
         if self.get_year() == other.get_year() :
            if self.get_month() == other.get_month() :
                if self.get_day() == other.get_day() :
                      return 0
                elif self.get_day() > other.get_day() :
                      return 1
                elif self.get_day() < other.get_day() :
                     return -1
            elif self.get_month() > other.get_month() :
                  return  1
            elif self.get_month() < other.get_month() :
                 return  -1
         elif self.get_year() > other.get_year() :
             return  1
         elif self.get_year() < other.get_year() :
             return -1
         return 0

    def equals(self, other) :
        if self.compare(other) == 0 :
            return True
        else : return False

    def to_string(self):
        return self.year +"/"+ self.month +"/"+ self.day
