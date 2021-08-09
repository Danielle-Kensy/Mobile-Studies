class Location {
  final String header;
  final String locationName;
  final int ratings;
  final String introTitle;
  final String introDescription;
  final List<String> locationPictures;
  final List<String> locationNames;
  
  Location({
    required this.header,
    required this.locationName,
    required this.ratings,
    required this.introTitle,
    required this.introDescription,
    required this.locationPictures,
    required this.locationNames,
  });
}
