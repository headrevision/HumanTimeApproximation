# HumanTimeApproximation

Textual approximation of a time duration (from seconds to years) in a Github-like manner, which prefers readability to accuracy.

## Examples
* 00:00:21 is repesented as "21 seconds"
* 00:02:30 is represented as "3 minutes"
* 02:30:00 is represented as "3 hours"
* 09:00:00 is represented as "half a day"
* 1d 12:00:00 is represented as "2 days"
* 7d 00:00:00 is represented as "a week"
* 28d 00:00:00 is represented as "a month"
* 2a 167d 23:59:59 is represented as "3 years"

## Simplifications
* support for Gregorian calendar only
* no [intercalation]( http://en.wikipedia.org/wiki/Intercalation_%28timekeeping%29 ), 1 month consists of 4 weeks (i.e. 28 days)
* no i18n/L10n (just simple English)
