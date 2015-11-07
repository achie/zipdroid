package com.zipcode.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    public static final String TIME_ZONE_UTC = "UTC";
    public static final String FORMAT_MONTH_DEFAULT = "M-yyyy";

    public static final String FORMAT_DATE_DEFAULT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"; //2015-10-08T22:59:55.282Z

    /**
     * Returns a {@link java.text.DateFormat} object using the supplied timezone and format.
     * @param timeZoneId
     * @param format
     * @return a {@link java.text.DateFormat} object using the supplied timezone and format.
     */
    public static DateFormat getDateFormat(@NonNull String timeZoneId, @NonNull String format) {
        DateFormat df = new SimpleDateFormat(format);
        df.setTimeZone(TimeZone.getTimeZone(timeZoneId));
        return df;
    }

    /**
     * Returns a {@link java.util.GregorianCalendar} with the time set to midnight of the day in UTC.
     * @param calendar a {@link android.support.annotation.NonNull} {@link java.util.Calendar} object for any day
     * @return a {@link android.support.annotation.NonNull} {@link java.util.GregorianCalendar}
     * with the time set to midnight of the input day in UTC
     */
    @NonNull
    public static Calendar getMidnightInUTC(@NonNull Calendar calendar) {
        GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone(TIME_ZONE_UTC));
        cal.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        cal.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        cal.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal;
    }

    /**
     * Returns a {@link java.util.GregorianCalendar} with the time set to midnight of the day in UTC.
     * @param timeInMilliseconds the time in milliseconds for any time of the day
     * @return a {@link android.support.annotation.NonNull} {@link java.util.GregorianCalendar}
     * with the time set to midnight of the input day in UTC
     */
    @NonNull
    public static Calendar getMidnightInUTC(long timeInMilliseconds) {
        GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone(TIME_ZONE_UTC));
        cal.setTimeInMillis(timeInMilliseconds);
        return getMidnightInUTC(cal);
    }

    /**
     * Returns a {@link java.util.GregorianCalendar} with the time set to today's midnight in UTC.
     * @return a {@link java.util.GregorianCalendar} with the time set to today's midnight in UTC
     */
    @NonNull
    public static Calendar getTodayMidnightInUTC() {
        return DateUtils.getMidnightInUTC(Calendar.getInstance());
    }

    /**
     * Returns a {@link java.util.GregorianCalendar} with of the supplied time in UTC.
     * @param timeInMilliseconds the time in milliseconds for any time of the day
     * @return a {@link android.support.annotation.NonNull} {@link java.util.GregorianCalendar} with of the supplied time in UTC
     */
    @NonNull
    public static Calendar getCalendarInUTC(long timeInMilliseconds) {
        GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone(TIME_ZONE_UTC));
        cal.setTimeInMillis(timeInMilliseconds);
        return cal;
    }

    /**
     * Returns a {@link java.util.GregorianCalendar} with the time set to midnight of the first day of the month in UTC.
     * @param calendar a {@link android.support.annotation.NonNull} {@link java.util.Calendar} object for any day in the month
     * @return a {@link android.support.annotation.NonNull} {@link java.util.GregorianCalendar} with the time set the midnight of the first day of the month in UTC
     */
    @NonNull
    public static Calendar getFirstDayOfMonthInUTC(@NonNull Calendar calendar) {
        Calendar cal = getMidnightInUTC(calendar);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal;
    }

    /**
     * Returns a {@link java.util.GregorianCalendar} with the time set to midnight of the last day of the month in UTC.
     * @param calendar a {@link android.support.annotation.NonNull} {@link java.util.Calendar} object for any day in the month
     * @return a {@link android.support.annotation.NonNull} {@link java.util.GregorianCalendar} with the time set the midnight of the last day of the month in UTC
     */
    @NonNull
    public static Calendar getLastDayOfMonthInUTC(@NonNull Calendar calendar) {
        Calendar cal = getMidnightInUTC(calendar);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal;
    }

    /**
     * Returns a {@link java.util.GregorianCalendar} with the time set to midnight of the first day of the week in UTC.
     * @param calendar a {@link android.support.annotation.NonNull} {@link java.util.Calendar} object for any day in the week
     * @return a {@link android.support.annotation.NonNull} {@link java.util.GregorianCalendar} with the time set the midnight of the first day of the week in UTC
     */
    @NonNull
    public static Calendar getFirstDayOfWeekInUTC(@NonNull Calendar calendar) {
        Calendar cal = getMidnightInUTC(calendar);
        cal.add(Calendar.DAY_OF_WEEK, -(cal.get(Calendar.DAY_OF_WEEK) - 1));
        return cal;
    }

    /**
     * Returns a {@link java.util.GregorianCalendar} with the time set to midnight of the last day of the week in UTC.
     * @param calendar a {@link android.support.annotation.NonNull} {@link java.util.Calendar} object for any day in the week
     * @return a {@link android.support.annotation.NonNull} {@link java.util.GregorianCalendar} with the time set the midnight of the last day of the week in UTC
     */
    @NonNull
    public static Calendar getLastDayOfWeekInUTC(@NonNull Calendar calendar) {
        Calendar cal = getMidnightInUTC(calendar);
        cal.add(Calendar.DAY_OF_WEEK, 7 - (cal.get(Calendar.DAY_OF_WEEK)));
        return cal;
    }

    /**
     * Returns true if both the {@link java.util.Calendar} objects are in the same day.
     * @param cal1 a {@link android.support.annotation.NonNull} {@link java.util.Calendar} object for any day
     * @param cal2 a {@link android.support.annotation.NonNull} {@link java.util.Calendar} object for any day
     * @return {@code true} if both the calendars are in the same UTC day or else {@code false}
     *
     * //TODO change this so that this also accounts for calendars supplied with different timezones
     */
    public static boolean areInSameDay(@NonNull Calendar cal1,
                                       @NonNull Calendar cal2) {
        DateFormat df = new SimpleDateFormat(FORMAT_DATE_DEFAULT);
        df.setTimeZone(TimeZone.getTimeZone(TIME_ZONE_UTC));
        return df.format(cal1.getTime()).equals(df.format(cal2.getTime()));
    }


    /**
     * Returns true if both the {@link java.util.Calendar} objects are in the same month.
     * @param cal1 a {@link android.support.annotation.NonNull} {@link java.util.Calendar} object for any day
     * @param cal2 a {@link android.support.annotation.NonNull} {@link java.util.Calendar} object for any day
     * @return {@code true} if both the calendars are in the same UTC month or else {@code false}
     *
     * //TODO change this so that this also accounts for calendars supplied with different timezones
     */
    public static boolean areInSameMonth(@NonNull Calendar cal1,
                                         @NonNull Calendar cal2) {
        DateFormat df = new SimpleDateFormat(FORMAT_MONTH_DEFAULT);
        df.setTimeZone(TimeZone.getTimeZone(TIME_ZONE_UTC));
        return df.format(cal1.getTime()).equals(df.format(cal2.getTime()));
    }

    /**
     * Returns the <b>non absolute</b> difference in months between two provider {@link java.util.Calendar} objects.
     * For example, if {@code calendar1} is in January 2015 and {@code calendar2} is in February 2015, then it returns 1.
     * If {@code calendar1} is in January 2015 and {@code calendar2} is in January 2014, then it returns -12.
     * @param calendar1 a {@link android.support.annotation.NonNull} {@link java.util.Calendar} object for any day
     * @param calendar2 a {@link android.support.annotation.NonNull} {@link java.util.Calendar} object for any day
     * @return the <b>non absolute</b> difference in months between two provider {@link java.util.Calendar} objects
     */
    public static long getDifferenceInMonths(@NonNull Calendar calendar1,
                                             @NonNull Calendar calendar2) {
        Calendar startCalendar = DateUtils.getMidnightInUTC(calendar1);
        Calendar endCalendar = DateUtils.getMidnightInUTC(calendar2);
        int differenceInYears = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        return differenceInYears * 12
                + endCalendar.get(Calendar.MONTH)
                - startCalendar.get(Calendar.MONTH);
    }

    /**
     * Returns the <b>non absolute</b> difference in days between two provider {@link java.util.Calendar} objects.
     * For example, if {@code calendar1} is in January 01 2015 and {@code calendar2} is in January 02 2015, then it returns 1.
     * If {@code calendar1} is in January 05 2015 and {@code calendar2} is in January 02 2015, then it returns -3.
     * @param calendar1 a {@link android.support.annotation.NonNull} {@link java.util.Calendar} object for any day
     * @param calendar2 a {@link android.support.annotation.NonNull} {@link java.util.Calendar} object for any day
     * @return the <b>non absolute</b> difference in days between two provider {@link java.util.Calendar} objects
     */
    public static long getDifferenceInDays(@NonNull Calendar calendar1,
                                           @NonNull Calendar calendar2) {
        Calendar startCalendar = DateUtils.getMidnightInUTC(calendar1);
        Calendar endCalendar = DateUtils.getMidnightInUTC(calendar2);
        return getDateDifference(startCalendar.getTime(), endCalendar.getTime(), TimeUnit.DAYS);
    }

    private static long getDateDifference(@NonNull Date date1,
                                          @NonNull Date date2, @NonNull TimeUnit timeUnit) {
        long diffInMillis = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }

    /**
     * Returns the {@code calendar1} object formatted as a string with the supplied format in UTC. This method does not check for the validity of the format string.
     * @param calendar a {@link android.support.annotation.NonNull} {@link java.util.Calendar} object for any day
     * @param format a {@link android.support.annotation.NonNull} {@link java.lang.String} that is in a valid format
     * @return a {@link android.support.annotation.NonNull} {@link java.lang.String} of the {@link java.util.Calendar} object formatted as a string in UTC
     */
    @NonNull
    public static String getDateStringInUTC(@NonNull Calendar calendar, @Nullable String format) {
        DateFormat df = new SimpleDateFormat(format);
        df.setTimeZone(TimeZone.getTimeZone(TIME_ZONE_UTC));
        return df.format(calendar.getTime());
    }

    /**
     * Returns a {@link java.util.Date} object of the supplied String and format
     * @param dateString any formatted date String
     * @param format the format of the date String
     * @return a {@link java.util.Date} object of the supplied String and format
     * @throws ParseException if an error occurs during parsing
     */
    public static Date getDateInUTC(@NonNull String dateString, @NonNull String format) throws ParseException {
        return getDateFormat(TIME_ZONE_UTC, format).parse(dateString);
    }

    /**
     * Returns a {@link java.util.Calendar} object of the supplied String and format in UTC
     * @param dateString any formatted date String
     * @param format the format of the date String
     * @return a {@link java.util.Date} object of the supplied String and format
     * @throws ParseException if an error occurs during parsing
     */
    public static Calendar getCalendarInUTC(@NonNull String dateString, @NonNull String format) throws ParseException {
        return getCalendarInUTC(getDateInUTC(dateString, format).getTime());
    }

    /**
     * Returns true of the calendar is between the start and end calendars. Both inclusive.
     * @param rangeStartCal the start time of the range
     * @param rangeEndCal the end time of the range
     * @param calendar the calendar which has to be checked for the range.
     * @return true if the day is in the range.
     */
    public static boolean isDayInRange(@Nullable Calendar rangeStartCal, @Nullable Calendar rangeEndCal, @Nullable Calendar calendar) {
        if (rangeStartCal == null || rangeEndCal == null || calendar == null) {
            return false;
        }

        if (calendar.before(rangeStartCal) && calendar.before(rangeEndCal)) {
            return false;
        }
        if (calendar.after(rangeStartCal) && calendar.after(rangeEndCal)) {
            return false;
        }

        return true;
    }

    /**
     * Checks if two time ranges are overlapping.
     * Assumes that times in range are in such a way that the start time is equal to or before the end time for the range.
     * Will return false if any of the supplied parameters is null.
     * @param range1StartCal
     * @param range1EndCal
     * @param range2StartCal
     * @param range2EndCal
     * @return true if the ranges intersect [inclusive of start and end times] and false otherwise
     */
    public static boolean areOverlappingRanges(@Nullable Calendar range1StartCal, @Nullable Calendar range1EndCal,
                                               @Nullable Calendar range2StartCal, @Nullable Calendar range2EndCal) {
        if (range1StartCal == null || range1EndCal == null || range2StartCal == null || range2EndCal == null) {
            return false;
        }

        if (range1StartCal.before(range2StartCal) && range1EndCal.before(range2StartCal)) {
            return false;
        }
        if (range1StartCal.after(range2EndCal) && range1EndCal.after(range2EndCal)) {
            return false;
        }

        return true;
    }

    /**
     * Returns the date strings of all the days in range [startDate-endDate] in the supplied format.
     * startDate time should not be after endDate time unless they are on the same day.
     * both startDate and endDate should be in the same timezone.
     * @param startDate
     * @param endDate
     * @param format the required format or null. If the format is null then it will return the days in the format "M-d-yyyy".
     * @return a set of date strings for each day in the range or empty set if either startDate or endDate are null
     * or if the startDate day is after the endDate day
     */
    public static Set<String> getDaysSet(@Nullable Calendar startDate, @Nullable Calendar endDate, @Nullable String format) {
        Set<String> daysWithData = new HashSet<String>();
        if (startDate == null || endDate == null) {
            return daysWithData;
        }

        Calendar startDateMidnight = DateUtils.getMidnightInUTC(startDate);
        Calendar endDateMidnight = DateUtils.getMidnightInUTC(endDate);

        if (startDateMidnight.after(endDateMidnight)) {
            return daysWithData;
        }

        if (TextUtils.isEmpty(format)) {
            format = FORMAT_DATE_DEFAULT;
        }

        DateFormat dateFormat = DateUtils.getDateFormat(DateUtils.TIME_ZONE_UTC, format);
        while (!startDateMidnight.after(endDateMidnight)) {
            daysWithData.add(dateFormat.format(startDateMidnight.getTime()));
            startDateMidnight.add(Calendar.DATE, 1);
        }
        return daysWithData;
    }

    @JsonProperty("endTime")
    public static Calendar getCalendar(String apiDateString) {
        Calendar calendar = null;
        if (!TextUtils.isEmpty(apiDateString)) {
            try {
                calendar = DateUtils.getCalendarInUTC(apiDateString,
                        DateUtils.FORMAT_DATE_DEFAULT);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return calendar;
    }

}
